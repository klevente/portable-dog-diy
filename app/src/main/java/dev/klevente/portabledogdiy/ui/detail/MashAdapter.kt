package dev.klevente.portabledogdiy.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.domain.Mash
import dev.klevente.portabledogdiy.ui.format
import kotlinx.android.synthetic.main.item_mash.view.*

class MashAdapter(private val c: Context) : ListAdapter<Mash, MashAdapter.ViewHolder>(MashComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mash, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mashTime: TextView = itemView.tvMashTime
        private val mashTemperature: TextView = itemView.tvMashTemperature

        fun bind(item: Mash) {
            mashTime.text = c.getString(R.string.mash_time_value, item.duration)
            mashTemperature.text = item.temperature.format()
        }
    }
}