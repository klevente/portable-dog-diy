package dev.klevente.portabledogdiy.ui.detail

import androidx.recyclerview.widget.DiffUtil
import dev.klevente.portabledogdiy.domain.Hop
import dev.klevente.portabledogdiy.domain.Malt
import dev.klevente.portabledogdiy.domain.Mash

object MaltComparator : DiffUtil.ItemCallback<Malt>() {
    override fun areItemsTheSame(oldItem: Malt, newItem: Malt): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Malt, newItem: Malt): Boolean {
        return oldItem == newItem
    }
}

object HopComparator : DiffUtil.ItemCallback<Hop>() {
    override fun areItemsTheSame(oldItem: Hop, newItem: Hop): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Hop, newItem: Hop): Boolean {
        return oldItem == newItem
    }
}

object MashComparator : DiffUtil.ItemCallback<Mash>() {
    override fun areItemsTheSame(oldItem: Mash, newItem: Mash): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Mash, newItem: Mash): Boolean {
        return oldItem == newItem
    }
}