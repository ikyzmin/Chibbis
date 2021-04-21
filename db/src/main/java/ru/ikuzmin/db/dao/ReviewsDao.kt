package ru.ikuzmin.db.dao

import androidx.room.*
import ru.ikuzmin.db.DbReview
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.domain.model.Review

@Dao
abstract class ReviewsDao {

    @Query("SELECT * FROM Review")
    abstract suspend fun reviews(): List<DbReview>

    @Insert
    abstract suspend fun insert(hits:List<DbReview>)

    @Delete
    abstract suspend fun delete(hits:List<DbReview>)

    @Update
    abstract suspend fun update(hit: DbReview)
}