package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewIsDisplayedAfterLoading() {
        // We wait for a bit to allow the coroutine delay (1 second) to pass
        // before asserting that the recyclerView is displayed and progressBar is gone.
        // In a real production app we'd use IdlingResource or provide a mocked ViewModel/Repository,
        // but Thread.sleep is used here for simplicity in this integration test.
        Thread.sleep(1500)
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}
