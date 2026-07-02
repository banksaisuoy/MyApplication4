package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*
import java.text.NumberFormat
import java.util.Locale

class ExampleUnitTest {

    @Test
    fun testMockDataGeneration() {
        val cryptos = MockData.cryptos
        assertNotNull("Cryptos list should not be null", cryptos)
        assertTrue("Cryptos list should not be empty", cryptos.isNotEmpty())
        assertEquals("Cryptos list should have exactly 10 items", 10, cryptos.size)

        val bitcoin = cryptos.first { it.symbol == "BTC" }
        assertNotNull("Bitcoin should be present in mock data", bitcoin)
        assertEquals("Bitcoin", bitcoin.name)
        assertTrue("Bitcoin price should be greater than 0", bitcoin.price > 0)
    }

    @Test
    fun testCurrencyFormatting() {
        val price = 64231.50
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedPrice = currencyFormat.format(price)

        assertEquals("\$64,231.50", formattedPrice)
    }
}