package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbReview
import ru.ikuzmin.db.model.LocalReview
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.model.Review

interface ReviewsInteractor {
    suspend fun insert(restaurants: List<DbReview>)
    suspend fun update(restaurants: DbReview)
    suspend fun delete(restaurants: List<DbReview>)
    suspend fun reviews(): List<Review>
}