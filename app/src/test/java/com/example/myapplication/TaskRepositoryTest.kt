package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TaskRepositoryTest {

    @Test
    fun testMockDataRepository() {
        val repository = MockDataRepository()
        val tasks = repository.getTasks()

        assertNotNull(tasks)
        assertEquals(5, tasks.size)

        val firstTask = tasks[0]
        assertNotNull(firstTask.id)
        assertEquals("Design new UI mockups", firstTask.title)
        assertEquals("Create high fidelity mockups for the new feature dashboard using Material Design 3 guidelines.", firstTask.description)
        assertFalse(firstTask.isCompleted)
    }

    @Test
    fun testTaskModel() {
        val task = Task("1", "Title", "Desc", false)
        assertEquals("1", task.id)
        assertEquals("Title", task.title)
        assertEquals("Desc", task.description)
        assertFalse(task.isCompleted)

        task.isCompleted = true
        assertTrue(task.isCompleted)
    }
}