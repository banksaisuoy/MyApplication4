package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun testGenerateMockData_returnsListWithCorrectSize() {
        val mockData = Task.generateMockData()
        assertNotNull("Mock data should not be null", mockData)
        assertEquals("Mock data should contain exactly 20 items", 20, mockData.size)
    }

    @Test
    fun testGenerateMockData_containsValidTasks() {
        val mockData = Task.generateMockData()
        val firstTask = mockData[0]

        assertEquals("First task ID should be 1", 1, firstTask.id)
        assertEquals("First task title should match", "Task 1", firstTask.title)
        assertEquals("First task description should match", "Description for task 1", firstTask.description)

        val lastTask = mockData[19]
        assertEquals("Last task ID should be 20", 20, lastTask.id)
        assertEquals("Last task title should match", "Task 20", lastTask.title)
    }
}
