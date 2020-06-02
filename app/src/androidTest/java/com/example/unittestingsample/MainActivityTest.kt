import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.unittestingsample.MainActivity
import com.example.unittestingsample.R
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        onView(withId(R.id.button_back)).perform(click()) // method 1
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).perform(click())
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


    @Test
    fun testVisibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.imageView))
            .check(matches(isDisplayed())) // method 1
        onView(withId(R.id.editTextEmail))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // method 2
        onView(withId(R.id.editTextPassword))
            .check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin))
            .check(matches(isDisplayed()))
    }


}
















