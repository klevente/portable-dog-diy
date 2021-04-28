package dev.klevente.portabledogdiy.ui.list

import androidx.recyclerview.widget.DiffUtil
import dev.klevente.portabledogdiy.ui.list.ListPresenter.BeerItem

object BeerItemComparator : DiffUtil.ItemCallback<BeerItem>() {
    override fun areItemsTheSame(oldItem: BeerItem, newItem: BeerItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BeerItem, newItem: BeerItem): Boolean {
        return oldItem == newItem
    }
}