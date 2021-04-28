package dev.klevente.portabledogdiy.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.ui.format
import dev.klevente.portabledogdiy.ui.list.ListPresenter.BeerItem
import kotlinx.android.synthetic.main.item_beer.view.*

class BeerAdapter(private val c: Context) : ListAdapter<BeerItem, BeerAdapter.ViewHolder>(BeerItemComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbnail: ImageView = itemView.ivThumbnailImage
        private val name: TextView = itemView.tvBeerName
        private val tagline: TextView = itemView.tvTagline
        private val abv: TextView = itemView.tvAbv
        private val ibu: TextView = itemView.tvIbu
        private val og: TextView = itemView.tvOg
        private val fg: TextView = itemView.tvFg
        private val volume: TextView = itemView.tvVolume
        private val boilVolume: TextView = itemView.tvBoilVolume

        private var beerItem: BeerItem? = null

        init {
            itemView.setOnClickListener {
                beerItem?.let { listener?.onBeerItemSelected(it.id) }
            }
        }

        fun bind(item: BeerItem) {
            beerItem = item

            name.text = item.name
            tagline.text = item.tagline
            abv.text = c.getString(R.string.abv_value, item.abv)
            ibu.text = c.getString(R.string.ibu_value, item.ibu)
            og.text = c.getString(R.string.og_value, item.og)
            fg.text = c.getString(R.string.fg_value, item.fg)
            volume.text = c.getString(R.string.volume_value, item.volume.format())
            boilVolume.text = c.getString(R.string.boil_volume_value, item.volume.format())


            Glide.with(thumbnail)
                .load(item.imageUrl)
                .into(thumbnail)
        }
    }

    interface Listener {
        fun onBeerItemSelected(id: Int)
    }
}