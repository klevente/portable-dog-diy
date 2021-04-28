package dev.klevente.portabledogdiy.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.domain.Malt
import dev.klevente.portabledogdiy.ui.format
import kotlinx.android.synthetic.main.item_malt.view.*

class MaltAdapter(private val c: Context) : ListAdapter<Malt, MaltAdapter.ViewHolder>(MaltComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_malt, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val maltName: TextView = itemView.tvMaltName
        private val maltQuantity: TextView = itemView.tvMaltQuantity

        fun bind(item: Malt) {
            maltName.text = item.name
            maltQuantity.text = item.amount.format()
        }
    }
}