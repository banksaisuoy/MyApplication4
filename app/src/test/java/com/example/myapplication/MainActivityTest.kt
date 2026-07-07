package com.example.myapplication

import org.junit.Test
import org.junit.Assert.assertEquals

class MainActivityTest {
    @Test
    fun testGetMessage() {
        val expectedMessage = "Hello World!"
        val actualMessage = MainActivity.getMessage()
        assertEquals(expectedMessage, actualMessage)
    }
}
