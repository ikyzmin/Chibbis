package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbRestaraunt
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.domain.model.Restaraunt

interface RestaurantsInteractor {
    suspend fun insert(restaurants: List<DbRestaraunt>)
    suspend fun update(restaurants: DbRestaraunt)
    suspend fun delete(restaurants: List<DbRestaraunt>)
    suspend fun restaurants(): List<Restaraunt>
}