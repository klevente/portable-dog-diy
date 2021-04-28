package dev.klevente.portabledogdiy.ui.edit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.klevente.portabledogdiy.databinding.ItemEditHopBinding
import dev.klevente.portabledogdiy.domain.MassUnit
import dev.klevente.portabledogdiy.ui.edit.EditPresenter.EditHop

class EditHopAdapter(private val context: Context) : RecyclerView.Adapter<EditHopAdapter.ViewHolder>() {

    private var hops: MutableList<EditHop> = mutableListOf()

    fun submitList(loadedHops: MutableList<EditHop>) {
        hops = loadedHops
        notifyDataSetChanged()
    }

    fun addHop() {
        hops.add(EditHop("", "0.0", 0, "start"))
        notifyItemInserted(hops.size - 1)
    }

    fun deleteHop(hop: EditHop) {
        hops.remove(hop)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemEditHopBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hops[position])
    }

    override fun getItemCount() = hops.size

    inner class ViewHolder(private val binding: ItemEditHopBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.spHopUnit.adapter = ArrayAdapter<MassUnit>(
                context, android.R.layout.simple_list_item_1, MassUnit.values()
            )
        }

        fun bind(item: EditHop) {
            binding.hop = item

            binding.btnDeleteHop.setOnClickListener {
                binding.hop?.let { deleteHop(it) }
            }
        }
    }
}