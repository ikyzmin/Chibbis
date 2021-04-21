package ru.ikuzmin.domain.repository

import ru.ikuzmin.domain.model.Restaraunt

interface RestarauntsRepository {
    suspend fun restaraunts():List<Restaraunt>
}