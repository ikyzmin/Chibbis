package ru.ikuzmin.remote.repository

import ru.ikuzmin.domain.repository.HitsRepository
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.remote.service.ChibbisServiceProvider

class RemoteHitsRepository(private val serviceProvider: ChibbisServiceProvider):HitsRepository {

    override suspend fun hits(): List<Hit> {
        return serviceProvider.chibbisService().hits()
    }
}