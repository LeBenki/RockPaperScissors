package com.example.rockpaperscissors

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.rockpaperscissors.model.Hand
import com.example.rockpaperscissors.ui.menu.MenuActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MenuActivity> = ActivityTestRule(MenuActivity::class.java)

    @Test
    fun checkIfSkippingHandChoice() {
        onView(withId(R.id.button_cpu_mode)).perform(click())
        onView(withId(R.id.result_text)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfGoodNumberOfHands() {
        onView(withId(R.id.button_player_mode)).perform(click())
        onView(withId(R.id.recycler_view_hand)).check(matches(hasChildCount(Hand.values().size)))
    }
}
