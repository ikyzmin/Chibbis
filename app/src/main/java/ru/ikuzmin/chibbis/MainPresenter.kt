package ru.ikuzmin.chibbis

interface MainPresenter {
    fun init(mainView: MainView)
    fun restaurantsSelected()
    fun reviewsSelected()
    fun hitsSelected()
}