package com.pjatk.quizmo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import com.pjatk.quizmo.fragments.Menu;
import com.pjatk.quizmo.fragments.MainActivity;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MenuInstrumentalTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testMenuFragmentCreation() {
        ActivityScenario<MainActivity> activityScenario = activityScenarioRule.getScenario();
        activityScenario.onActivity(activity -> {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            Fragment menuFragment = fragmentManager.findFragmentById(R.id.nav_host_fragment_content_main);
            Assert.assertNotNull(menuFragment);
        });
    }
}
