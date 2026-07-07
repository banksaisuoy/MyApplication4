package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testRecyclerViewIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun testFirstItemIsDisplayedAndClickable() {
        ActivityScenario.launch(MainActivity::class.java)

        // Check first task title is displayed
        onView(withText("Design new UI mockups")).check(matches(isDisplayed()))

        // Click first item in the list
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TaskAdapter.TaskViewHolder>(0, click()))

        // The status of first item should be changed to Completed
        onView(withText("Completed")).check(matches(isDisplayed()))
    }
}