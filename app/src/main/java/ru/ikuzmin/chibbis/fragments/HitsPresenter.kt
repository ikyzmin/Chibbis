package ru.ikuzmin.chibbis.fragments

interface HitsPresenter {
    fun loadHits(update:Boolean)
    fun init(hitsView: HitsView)
}