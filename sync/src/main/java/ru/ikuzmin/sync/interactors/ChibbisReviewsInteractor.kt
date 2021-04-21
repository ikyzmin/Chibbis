package ru.ikuzmin.sync.interactors

import ru.ikuzmin.db.DbReview
import ru.ikuzmin.db.model.LocalReview
import ru.ikuzmin.db.repository.LocalReviewsRepository
import ru.ikuzmin.domain.model.Review
import ru.ikuzmin.domain.repository.ReviewsRepository

class ChibbisReviewsInteractor(
    private val localReviewsRepository: LocalReviewsRepository,
    private val remoteReviewsRepository: ReviewsRepository
) : ReviewsInteractor {
    override suspend fun insert(restaurants: List<DbReview>) {
        localReviewsRepository.insert(restaurants)
    }

    override suspend fun update(restaurants: DbReview) {
        localReviewsRepository.update(restaurants)
    }

    override suspend fun delete(restaurants: List<DbReview>) {
        localReviewsRepository.delete(restaurants)
    }

    override suspend fun reviews(): List<Review> {
        return remoteReviewsRepository.reviews()
    }
}