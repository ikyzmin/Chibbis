package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbRestaraunt
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.db.repository.LocalRestaurantsRepository
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.domain.repository.RestarauntsRepository

class ChibbisRestaurantsInteractor(
    private val localRestaurantsRepository: LocalRestaurantsRepository,
    private val remoteRestaurantsRepository: RestarauntsRepository
) : RestaurantsInteractor {
    override suspend fun insert(restaurants: List<DbRestaraunt>) {
        localRestaurantsRepository.insert(restaurants)
    }

    override suspend fun update(restaurants: DbRestaraunt) {
        localRestaurantsRepository.update(restaurants)
    }

    override suspend fun delete(restaurants: List<DbRestaraunt>) {
        localRestaurantsRepository.delete(restaurants)
    }

    override suspend fun restaurants(): List<Restaraunt> {
        return remoteRestaurantsRepository.restaraunts()
    }
}