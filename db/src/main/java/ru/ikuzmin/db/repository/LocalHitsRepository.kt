package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbHit
import ru.ikuzmin.db.model.LocalHit
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.repository.HitsRepository

interface LocalHitsRepository : HitsRepository {

    suspend fun insert(hits: List<DbHit>)
    suspend fun update(hit: DbHit)
    suspend fun delete(hits: List<DbHit>)
}