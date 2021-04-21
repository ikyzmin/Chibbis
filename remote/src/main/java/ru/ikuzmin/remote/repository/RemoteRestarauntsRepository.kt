package ru.ikuzmin.remote.repository

import ru.ikuzmin.domain.repository.RestarauntsRepository
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.remote.service.ChibbisServiceProvider

class RemoteRestarauntsRepository(private val serviceProvider: ChibbisServiceProvider):RestarauntsRepository {
    override suspend fun restaraunts(): List<Restaraunt> {
        return serviceProvider.chibbisService().restaraunts()
    }
}