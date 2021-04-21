package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbRestaraunt
import ru.ikuzmin.db.model.LocalHit
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.repository.HitsRepository
import ru.ikuzmin.domain.repository.RestarauntsRepository

interface LocalRestaurantsRepository:RestarauntsRepository {
    suspend fun insert(hits: List<DbRestaraunt>)
    suspend fun update(hit: DbRestaraunt)
    suspend fun delete(hits: List<DbRestaraunt>)
}