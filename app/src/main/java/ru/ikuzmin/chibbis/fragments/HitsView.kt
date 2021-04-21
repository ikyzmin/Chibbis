package ru.ikuzmin.chibbis.fragments

import ru.ikuzmin.domain.model.Hit

interface HitsView {
    fun showProgress()
    fun hideProgress()
    fun showUpdate()
    fun hideUpdate()
    fun showHits(hits:List<Hit>)
}