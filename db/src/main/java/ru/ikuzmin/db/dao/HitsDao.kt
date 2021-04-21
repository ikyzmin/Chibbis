package ru.ikuzmin.db.dao

import androidx.room.*
import ru.ikuzmin.db.DbHit
import ru.ikuzmin.domain.model.Hit

@Dao
abstract class HitsDao {

    @Query("SELECT * FROM Hit")
    abstract suspend fun hits():List<DbHit>

    @Insert
    abstract suspend fun insert(hits:List<DbHit>)

    @Delete
    abstract suspend fun delete(hits:List<DbHit>)

    @Update
    abstract suspend fun update(hit:DbHit)
}