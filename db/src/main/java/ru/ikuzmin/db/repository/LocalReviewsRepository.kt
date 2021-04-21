package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbReview
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.db.model.LocalReview
import ru.ikuzmin.domain.repository.ReviewsRepository

interface LocalReviewsRepository:ReviewsRepository {
    suspend fun insert(hits: List<DbReview>)
    suspend fun update(hit: DbReview)
    suspend fun delete(hits: List<DbReview>)
}