package dev.klevente.portabledogdiy.ui.edit

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.databinding.ItemEditMashBinding
import dev.klevente.portabledogdiy.domain.TemperatureUnit
import dev.klevente.portabledogdiy.ui.edit.EditPresenter.EditMash


class EditMashAdapter(private val context: Context) : RecyclerView.Adapter<EditMashAdapter.ViewHolder>() {

    private var mashList: MutableList<EditMash> = mutableListOf()

    fun submitList(loadedMash: MutableList<EditMash>) {
        mashList = loadedMash
        notifyDataSetChanged()
    }

    fun addMash() {
        mashList.add(EditMash("0.0", 0, "0"))
        notifyItemInserted(mashList.size - 1)
    }

    fun deleteMash(mash: EditMash) {
        mashList.remove(mash)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemEditMashBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mashList[position])
    }

    override fun getItemCount() = mashList.size

    inner class ViewHolder(private val binding: ItemEditMashBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.spMashUnit.adapter = ArrayAdapter<TemperatureUnit>(
                context, R.layout.simple_list_item_1, TemperatureUnit.values()
            )
        }

        fun bind(item: EditMash) {
            binding.mash = item

            binding.btnDeleteMash.setOnClickListener {
                binding.mash?.let { deleteMash(it) }
            }
        }
    }
}