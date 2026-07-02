package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CryptoAdapter(private val cryptos: List<Crypto>) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCoinName: TextView = itemView.findViewById(R.id.tvCoinName)
        val tvCoinSymbol: TextView = itemView.findViewById(R.id.tvCoinSymbol)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvChange: TextView = itemView.findViewById(R.id.tvChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptos[position]
        holder.tvCoinName.text = crypto.name
        holder.tvCoinSymbol.text = crypto.symbol

        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
        holder.tvPrice.text = currencyFormat.format(crypto.price)

        val changeText = if (crypto.changePercentage > 0) {
            "+${crypto.changePercentage}%"
        } else {
            "${crypto.changePercentage}%"
        }
        holder.tvChange.text = changeText

        val color = if (crypto.changePercentage >= 0) Color.parseColor("#4CAF50") else Color.parseColor("#F44336")
        holder.tvChange.setTextColor(color)
    }

    override fun getItemCount(): Int {
        return cryptos.size
    }
}
