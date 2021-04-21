package ru.ikuzmin.chibbis.fragments

import kotlinx.coroutines.*
import ru.ikuzmin.sync.interactors.RestaurantsInteractor

class ChibbisRestaurantPresenter(private val restaurantsInteractor: RestaurantsInteractor) :
    RestaurantsPresenter {

    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.IO)
    private lateinit var view: RestarauntsView

    override fun init(restarauntsView: RestarauntsView) {
        view = restarauntsView
    }

    override fun dispose() {
        job.complete()
    }

    override fun loadRestaurants() {
        view.showProgress()
        scope.launch {
            val restaurants = restaurantsInteractor.restaurants()
            withContext(Dispatchers.Main) {
                view.hideProgress()
                view.showRestaurants(restaurants)
            }
        }
    }
}