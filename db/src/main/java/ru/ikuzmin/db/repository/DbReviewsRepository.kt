package ru.ikuzmin.db.repository

import ru.ikuzmin.db.DbReview
import ru.ikuzmin.db.dao.ReviewsDao
import ru.ikuzmin.db.model.LocalReview
import ru.ikuzmin.domain.model.Review
import ru.ikuzmin.domain.repository.ReviewsRepository

class DbReviewsRepository(private val reviewsDao: ReviewsDao) : LocalReviewsRepository {
    override suspend fun insert(hits: List<DbReview>) {
        reviewsDao.insert(hits)
    }

    override suspend fun update(hit: DbReview) {
        reviewsDao.update(hit)
    }

    override suspend fun delete(hits: List<DbReview>) {
        reviewsDao.delete(hits)
    }

    override suspend fun reviews(): List<Review> {
        return reviewsDao.reviews()
    }
}