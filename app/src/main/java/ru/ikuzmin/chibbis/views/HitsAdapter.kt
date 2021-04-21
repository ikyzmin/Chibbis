package ru.ikuzmin.chibbis.views

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.domain.model.Hit

class HitsAdapter(context: Context, private val itemLongClickListener: ItemLongClickListener) :
    RecyclerView.Adapter<HitsAdapter.HitsViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private val hits = ArrayList<Hit>()

    fun setItem(hits: List<Hit>) {
        this.hits.clear()
        this.hits.addAll(hits)
        notifyDataSetChanged()
    }

    inner class HitsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(hit: Hit, position: Int) {
            val image = view.findViewById<ImageView>(R.id.hit_image)
            val hitName = view.findViewById<TextView>(R.id.name)
            image.setOnLongClickListener {
                itemLongClickListener.onLongClicked(it, hit)
                true
            }
            image.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    itemLongClickListener.onReleased()
                    return@setOnTouchListener true
                }
                return@setOnTouchListener false
            }
            hitName.text = hit.productName
            Picasso.get().load(hit.productImageURL).resizeDimen(R.dimen.hit_size, R.dimen.hit_size)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitsViewHolder {
        val view = inflater.inflate(R.layout.item_hit, parent, false)
        return HitsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HitsViewHolder, position: Int) {
        holder.bind(hits[position], position)
    }

    override fun getItemCount(): Int {
        return hits.size
    }

    interface ItemLongClickListener {
        fun onLongClicked(v: View, item: Hit)
        fun onReleased()
    }
}