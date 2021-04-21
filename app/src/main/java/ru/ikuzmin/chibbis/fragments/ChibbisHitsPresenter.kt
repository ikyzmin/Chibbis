package ru.ikuzmin.chibbis.fragments

import kotlinx.coroutines.*
import ru.ikuzmin.sync.interactors.HitsInteractor

class ChibbisHitsPresenter(private val hitsInteractor: HitsInteractor) : HitsPresenter {
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.IO)
    lateinit var view: HitsView
    override fun loadHits(update: Boolean) {
        if (!update) {
            view.showProgress()
        }
        scope.launch {
            val hits = hitsInteractor.hits()
            withContext(Dispatchers.Main) {
                view.hideUpdate()
                view.showHits(hits)
                if (!update) {
                    view.hideProgress()
                }
            }
        }
    }

    override fun init(hitsView: HitsView) {
        view = hitsView
    }
}