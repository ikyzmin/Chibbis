package ru.ikuzmin.db.dao

import androidx.room.*
import ru.ikuzmin.db.DbRestaraunt
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.model.Restaraunt

@Dao
abstract class RestaurantsDao {
    @Query("SELECT * FROM Restaurant")
    abstract suspend fun restaraunts():List<DbRestaraunt>

    @Insert
    abstract suspend fun insert(hits:List<DbRestaraunt>)

    @Delete
    abstract suspend fun delete(hits:List<DbRestaraunt>)

    @Update
    abstract suspend fun update(hit: DbRestaraunt)
}