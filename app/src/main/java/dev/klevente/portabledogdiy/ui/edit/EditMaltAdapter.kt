package dev.klevente.portabledogdiy.ui.edit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.databinding.ItemEditMaltBinding
import dev.klevente.portabledogdiy.domain.MassUnit
import dev.klevente.portabledogdiy.ui.edit.EditPresenter.EditMalt

class EditMaltAdapter(private val context: Context) : RecyclerView.Adapter<EditMaltAdapter.ViewHolder>() {

    private var malts: MutableList<EditMalt> = mutableListOf()

    fun submitList(loadedMalts: MutableList<EditMalt>) {
        malts = loadedMalts
        notifyDataSetChanged()
    }

    fun addMalt() {
        malts.add(EditMalt("", "0.0", 0))
        notifyItemInserted(malts.size - 1)
    }

    fun deleteMalt(malt: EditMalt) {
        malts.remove(malt)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemEditMaltBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(malts[position])
    }

    override fun getItemCount() = malts.size

    inner class ViewHolder(private val binding: ItemEditMaltBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.spMaltUnit.adapter = ArrayAdapter<MassUnit>(
                context, android.R.layout.simple_list_item_1, MassUnit.values()
            )
        }

        fun bind(item: EditMalt) {
            binding.malt = item

            binding.btnDeleteMalt.setOnClickListener {
                binding.malt?.let { deleteMalt(it) }
            }
        }
    }
}