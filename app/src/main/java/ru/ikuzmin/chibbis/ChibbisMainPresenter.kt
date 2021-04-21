package ru.ikuzmin.chibbis

class ChibbisMainPresenter : MainPresenter {

    private lateinit var view: MainView
    override fun init(mainView: MainView) {
        view = mainView
        view.showRestaurants()
    }

    override fun restaurantsSelected() {
        view.showRestaurants()
    }

    override fun reviewsSelected() {
        view.showReviews()
    }

    override fun hitsSelected() {
        view.showHits()
    }
}