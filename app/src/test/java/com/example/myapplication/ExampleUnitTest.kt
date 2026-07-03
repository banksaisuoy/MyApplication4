package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun task_creationIsCorrect() {
        val task = Task(1, "Test Title", "Test Description", true)
        assertEquals(1, task.id)
        assertEquals("Test Title", task.title)
        assertEquals("Test Description", task.description)
        assertTrue(task.isCompleted)
    }
}