package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewIsDisplayedAndPopulated() {
        // Verify RecyclerView is displayed
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        // Verify the first item has the expected title
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollToPosition<TaskAdapter.TaskViewHolder>(0))

        onView(withText("Task 1")).check(matches(isDisplayed()))

        // Verify the last item has the expected title
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollToPosition<TaskAdapter.TaskViewHolder>(19))

        onView(withText("Description for task 20")).check(matches(isDisplayed()))
    }
}
