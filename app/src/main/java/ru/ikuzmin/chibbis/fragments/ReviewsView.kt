package ru.ikuzmin.chibbis.fragments

import ru.ikuzmin.domain.model.Review

interface ReviewsView {
    fun showProgress()
    fun hideProgress()
    fun showUpdate()
    fun hideUpdate()
    fun showReviews(reviews: List<Review>)
}