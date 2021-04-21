package ru.ikuzmin.chibbis.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.domain.model.Restaraunt

class RestaurantsAdapter(private val context: Context) :
    RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    private val restaurants = ArrayList<Restaraunt>()
    private val viewedRestaurants = ArrayList<Restaraunt>()
    private val inflater = LayoutInflater.from(context)

    fun setItems(restaurants: List<Restaraunt>) {
        this.restaurants.clear()
        this.restaurants.addAll(restaurants)
        viewedRestaurants.clear()
        viewedRestaurants.addAll(restaurants)
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        if (query.isEmpty()) {
            viewedRestaurants.clear()
            viewedRestaurants.addAll(restaurants)
            notifyDataSetChanged()
        } else {
            viewedRestaurants.clear()
            viewedRestaurants.addAll(restaurants.filter { it.name.toLowerCase().contains(query) })
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val root: View = inflater.inflate(R.layout.item_restaurant, parent, false)
        return RestaurantsViewHolder(root)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.bind(viewedRestaurants[position])
    }

    override fun getItemCount(): Int {
        return viewedRestaurants.size
    }

    inner class RestaurantsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(restaraunt: Restaraunt) {
            val name = view.findViewById<TextView>(R.id.name)
            val specs = view.findViewById<TextView>(R.id.specialization)
            val reviews = view.findViewById<TextView>(R.id.positives_reviews)
            name.text = restaraunt.name
            reviews.text = context.resources.getString(
                R.string.reviews_percent,
                restaraunt.positiveReviewCount
            )
            val image = view.findViewById<ImageView>(R.id.logo)
            specs.text = restaraunt.specialization.map { it.name }.joinToString(" / ")
            Picasso.get().load(restaraunt.logoURL).placeholder(R.drawable.ic_food_placeholder)
                .resizeDimen(R.dimen.logo_size, R.dimen.logo_size).into(image)
        }
    }
}