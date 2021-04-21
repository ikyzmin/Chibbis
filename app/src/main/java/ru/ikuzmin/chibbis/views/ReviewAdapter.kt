package ru.ikuzmin.chibbis.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.domain.model.Review
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ReviewAdapter(private val context: Context) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private val reviews = ArrayList<Review>()

    fun setItems(reviews: List<Review>) {
        this.reviews.clear()
        this.reviews.addAll(reviews)
        notifyDataSetChanged()
    }

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:MM:SS", Locale.getDefault())
        private val viewDateFormat = SimpleDateFormat("dd.MM.yyyy HH:MM", Locale.getDefault())


        fun bind(review: Review) {
            val title = itemView.findViewById<TextView>(R.id.review_title)
            val message = itemView.findViewById<TextView>(R.id.review_message)
            val date = itemView.findViewById<TextView>(R.id.review_date)
            if (review.isPositive) {
                val positiveDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_positive_reviews)
                val wrappedDrawable = DrawableCompat.wrap(positiveDrawable!!)
                TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(title,wrappedDrawable, null, null, null)
            } else {
                val negativeDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_negative)
                val wrappedDrawable = DrawableCompat.wrap(negativeDrawable!!)
                TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(title,wrappedDrawable, null, null, null)
            }
            title.text = context.resources.getString(R.string.review_title,review.userName.trim(),review.restarauntName)
            message.text = review.message
            date.text = viewDateFormat.format(dateFormat.parse(review.data))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = inflater.inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount(): Int {
        return reviews.size
    }
}