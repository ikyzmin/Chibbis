package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbHit
import ru.ikuzmin.db.model.LocalHit
import ru.ikuzmin.db.repository.LocalHitsRepository
import ru.ikuzmin.db.repository.LocalRestaurantsRepository
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.repository.HitsRepository
import ru.ikuzmin.domain.repository.RestarauntsRepository

class ChibbisHitsInteractor(
    private val localRestaurantsRepository: LocalHitsRepository,
    private val remoteRestaurantsRepository: HitsRepository
) : HitsInteractor {
    override suspend fun insert(hits: List<DbHit>) {
        localRestaurantsRepository.insert(hits)
    }

    override suspend fun update(hit: DbHit) {
        localRestaurantsRepository.update(hit)
    }

    override suspend fun delete(hits: List<DbHit>) {
        localRestaurantsRepository.delete(hits)
    }

    override suspend fun hits(): List<Hit> {
        return remoteRestaurantsRepository.hits()
    }
}