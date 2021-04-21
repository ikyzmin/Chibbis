package ru.ikuzmin.chibbis.fragments

interface ReviewsPresenter {
    fun init(reviewsView: ReviewsView)
    fun loadReviews(update:Boolean)
}