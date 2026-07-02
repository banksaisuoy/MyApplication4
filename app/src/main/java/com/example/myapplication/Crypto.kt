package com.example.myapplication

data class Crypto(
    val name: String,
    val symbol: String,
    val price: Double,
    val changePercentage: Double
)

object MockData {
    val cryptos = listOf(
        Crypto("Bitcoin", "BTC", 64231.50, 2.5),
        Crypto("Ethereum", "ETH", 3452.20, -1.2),
        Crypto("Binance Coin", "BNB", 420.80, 0.8),
        Crypto("Solana", "SOL", 145.60, 5.4),
        Crypto("Cardano", "ADA", 0.45, -2.1),
        Crypto("Ripple", "XRP", 0.52, 1.1),
        Crypto("Dogecoin", "DOGE", 0.15, 12.5),
        Crypto("Polkadot", "DOT", 7.20, -0.5),
        Crypto("Polygon", "MATIC", 0.75, 3.2),
        Crypto("Chainlink", "LINK", 18.40, -1.8)
    )
}
