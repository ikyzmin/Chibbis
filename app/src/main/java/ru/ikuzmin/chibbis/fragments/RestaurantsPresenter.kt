package ru.ikuzmin.chibbis.fragments

interface RestaurantsPresenter {
    fun init(restarauntsView: RestarauntsView)
    fun dispose()
    fun loadRestaurants()
}