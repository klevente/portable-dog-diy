package dev.klevente.portabledogdiy.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.domain.Hop
import dev.klevente.portabledogdiy.ui.format
import kotlinx.android.synthetic.main.item_hop.view.*

class HopAdapter(private val c: Context) : ListAdapter<Hop, HopAdapter.ViewHolder>(HopComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val hopName: TextView = itemView.tvHopName
        private val hopQuantity: TextView = itemView.tvHopQuantity
        private val hopAddition: TextView = itemView.tvHopAddition

        fun bind(item: Hop) {
            hopName.text = item.name
            hopQuantity.text = item.amount.format()
            hopAddition.text = item.add
        }
    }
}