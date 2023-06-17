package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentPlayBinding;
import com.pjatk.quizmo.logic.LocalStorageManager;
import com.pjatk.quizmo.logic.QuizManager;
import com.pjatk.quizmo.logic.QuizQuestion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Play extends Fragment {

    private FragmentPlayBinding binding;
    private QuizManager quizManager;
    private String playButtonIdentifier;
    private LocalStorageManager localStorageManager;
    private String gameName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        playButtonIdentifier = getArguments().getString("playButtonIdentifier");
        localStorageManager = new LocalStorageManager();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<QuizQuestion> quizQuestionList = createQuizQuestions();

        quizManager = new QuizManager(quizQuestionList);

        showNextQuestionFromList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Creates a list of QuizQuestions based on the selected game.
     *
     * @return The list of QuizQuestions.
     */
    private List<QuizQuestion> createQuizQuestions(){
        if (playButtonIdentifier.equals("game1")){
            gameName = "wiedzmin";
        } else if (playButtonIdentifier.equals("game2")) {
            gameName = "starcraft";
        }
        else if (playButtonIdentifier.equals("game3")) {
            gameName = "lol";
        }
        else if (playButtonIdentifier.equals("game4")) {
            gameName = "hearthstone";
        }
        return getDataFromJsonToQuizQuestionList(gameName);
    }

    /**
     * Retrieves quiz questions from a JSON file and converts them into a list of QuizQuestions.
     *
     * @param fileName The name of the JSON file containing the quiz questions.
     * @return The list of QuizQuestions.
     */
    private List<QuizQuestion> getDataFromJsonToQuizQuestionList(String fileName){
        List<QuizQuestion> quizQuestionList = new ArrayList<>();

        try{
            InputStream inputStream = getContext().getAssets().open(fileName+".json");
            int inputSize = inputStream.available();
            byte[] buffer = new byte[inputSize];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject questionObject = jsonArray.getJSONObject(i);

                String question = questionObject.getString("question");
                JSONArray answersArray = questionObject.getJSONArray("options");
                int correctAnswer = questionObject.getInt("correctAnswer");

                List<String> answers = new ArrayList<>();
                for (int j = 0; j < answersArray.length(); j++)
                    answers.add(answersArray.getString(j));

                QuizQuestion quizQuestion = new QuizQuestion(question, answers, correctAnswer);
                quizQuestionList.add(quizQuestion);
            }

        }
        catch (IOException | JSONException e){
            e.printStackTrace();
        }
        System.out.println(quizQuestionList);
        return quizQuestionList;
    }

    /**
     * Displays the next quiz question from the list or shows the quiz results if the quiz is finished.
     */
    private void showNextQuestionFromList(){
        if (quizManager.isQuizFinished())
            showAndSaveQuizResults();
        else {
            QuizQuestion currentQuestion = quizManager.getCurrentQuestionFromList();
            binding.questionPl.setText(currentQuestion.getQuestion());
            List<String> answers = currentQuestion.getPossibleAnswers();

            binding.answer1ButtonPl.setText(answers.get(0));
            binding.answer1ButtonPl.setOnClickListener(new AnswerClickListener(0));

            binding.answer2ButtonPl.setText(answers.get(1));
            binding.answer2ButtonPl.setOnClickListener(new AnswerClickListener(1));

            binding.answer3ButtonPl.setText(answers.get(2));
            binding.answer3ButtonPl.setOnClickListener(new AnswerClickListener(2));

            binding.answer4ButtonPl.setText(answers.get(3));
            binding.answer4ButtonPl.setOnClickListener(new AnswerClickListener(3));

            updateScore();
        }
    }

    /**
     * Shows the quiz results, saves the score, and navigates back to the menu.
     */
    private void showAndSaveQuizResults(){
        Toast.makeText(getActivity(), "Koniec! Wynik: " + String.valueOf(quizManager.getScore()), Toast.LENGTH_SHORT).show();
        localStorageManager.saveScoreToLocalStorage(getContext(), String.valueOf(quizManager.getScore()));
        localStorageManager.saveLeaderboardNameToLocalStorage(getContext(), localStorageManager.getNickNameFromLocalStorage(getContext()));
        NavHostFragment.findNavController(Play.this)
                .navigate(R.id.action_play_to_menu);
    }

    /**
     * Updates the displayed score.
     */
    private void updateScore(){
        binding.wynikTextviewChangable.setText("Score: " + quizManager.getScore());
    }

    /**
     * Click listener for the answer buttons. Handles the user's answer selection and shows the next question.
     */
    private class AnswerClickListener implements View.OnClickListener {
        private int selectedAnswer;

        public AnswerClickListener(int selectedAnswer){
            this.selectedAnswer = selectedAnswer;
        }

        @Override
        public void onClick(View v){
            quizManager.answerQuestion(selectedAnswer);
            showNextQuestionFromList();
        }
    }
}
