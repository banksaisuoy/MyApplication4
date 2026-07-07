package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Item(val title: String, val description: String)

object DataProvider {
    fun getMockData(): List<Item> {
        return List(100) { index ->
            Item(
                title = "Item $index",
                description = "Description for item $index"
            )
        }
    }
}

class ItemAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.textViewTitle)
        val descriptionView: TextView = view.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
        holder.descriptionView.text = item.description
    }

    override fun getItemCount() = items.size
}