package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Test
    fun displaysRecyclerViewAndItems() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Wait a little for the coroutine to complete its mocked delay (500ms)
        Thread.sleep(1000)

        // Check if RecyclerView is displayed
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        // Note: Espresso contrib (RecyclerViewActions) is often needed for deep assertions
        // Here we just verify a known text item loads on screen after delay
        onView(withText("Fix Layout Bugs")).check(matches(isDisplayed()))

        scenario.close()
    }
}
