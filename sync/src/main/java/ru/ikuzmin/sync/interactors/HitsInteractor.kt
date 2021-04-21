package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbHit
import ru.ikuzmin.db.model.LocalHit
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.model.Restaraunt

interface HitsInteractor {
    suspend fun insert(restaurants: List<DbHit>)
    suspend fun update(restaurants: DbHit)
    suspend fun delete(restaurants: List<DbHit>)
    suspend fun hits(): List<Hit>
}