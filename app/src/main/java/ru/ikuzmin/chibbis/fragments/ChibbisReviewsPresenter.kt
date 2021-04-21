package ru.ikuzmin.chibbis.fragments

import kotlinx.coroutines.*
import ru.ikuzmin.sync.interactors.ReviewsInteractor
import java.text.SimpleDateFormat
import java.util.*

class ChibbisReviewsPresenter(private val interactor: ReviewsInteractor) : ReviewsPresenter {

    private lateinit var view: ReviewsView
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.IO)

    override fun init(reviewsView: ReviewsView) {
        view = reviewsView
    }

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:MM:SS", Locale.getDefault())


    override fun loadReviews(update: Boolean) {
        if (!update) {
            view.showProgress()
        }
        scope.launch {
            val reviews = interactor.reviews()
            withContext(Dispatchers.Main) {
                if (!update) {
                    view.hideProgress()
                    view.showReviews(reviews.sortedBy { dateFormat.parse(it.data) })
                } else {
                    view.hideUpdate()
                }
            }
        }
    }
}