package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbHit
import ru.ikuzmin.db.dao.HitsDao
import ru.ikuzmin.db.model.LocalHit
import ru.ikuzmin.domain.model.Hit

class DbHitsRepository(private val hitsDao: HitsDao) : LocalHitsRepository {
    override suspend fun insert(hits: List<DbHit>) {
        hitsDao.insert(hits)
    }

    override suspend fun update(hit: DbHit) {
        hitsDao.update(hit)
    }

    override suspend fun delete(hits: List<DbHit>) {
        hitsDao.delete(hits)
    }

    override suspend fun hits(): List<DbHit> {
        return hitsDao.hits()
    }
}