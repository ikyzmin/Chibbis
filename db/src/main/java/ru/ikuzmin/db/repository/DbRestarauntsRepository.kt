package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbRestaraunt
import ru.ikuzmin.db.dao.RestaurantsDao
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.domain.repository.RestarauntsRepository

class DbRestarauntsRepository(private val restarauntsDao: RestaurantsDao) : LocalRestaurantsRepository {
    override suspend fun insert(hits: List<DbRestaraunt>) {
        restarauntsDao.insert(hits)
    }

    override suspend fun update(hit: DbRestaraunt) {
        restarauntsDao.update(hit)
    }

    override suspend fun delete(hits: List<DbRestaraunt>) {
        restarauntsDao.delete(hits)
    }

    override suspend fun restaraunts(): List<Restaraunt> {
        return restarauntsDao.restaraunts()
    }
}