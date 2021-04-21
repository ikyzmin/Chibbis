package ru.ikuzmin.domain.repository

import ru.ikuzmin.domain.model.Hit

interface HitsRepository {
    suspend fun hits():List<Hit>
}