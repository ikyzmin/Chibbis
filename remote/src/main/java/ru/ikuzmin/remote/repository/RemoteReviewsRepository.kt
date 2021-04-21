package ru.ikuzmin.remote.repository

import ru.ikuzmin.domain.repository.ReviewsRepository
import ru.ikuzmin.domain.model.Review
import ru.ikuzmin.remote.service.ChibbisServiceProvider

class RemoteReviewsRepository(private val serviceProvider: ChibbisServiceProvider) :
    ReviewsRepository {
    override suspend fun reviews(): List<Review> {
        return serviceProvider.chibbisService().reviews()
    }
}