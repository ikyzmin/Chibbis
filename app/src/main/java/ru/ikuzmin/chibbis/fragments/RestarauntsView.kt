package ru.ikuzmin.chibbis.fragments

import ru.ikuzmin.domain.model.Restaraunt

interface RestarauntsView {
    fun showProgress()
    fun hideProgress()
    fun showRestaurants(restaurants:List<Restaraunt>)
}