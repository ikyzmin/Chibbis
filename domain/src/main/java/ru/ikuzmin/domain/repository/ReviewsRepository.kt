package ru.ikuzmin.domain.repository

import ru.ikuzmin.domain.model.Review

interface ReviewsRepository {
    suspend fun reviews():List<Review>
}