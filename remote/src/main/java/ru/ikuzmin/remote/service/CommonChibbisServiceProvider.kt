package ru.ikuzmin.remote.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommonChibbisServiceProvider: ChibbisServiceProvider {
    override fun chibbisService(): ChibbisService {
       return Retrofit.Builder().baseUrl("https://front-task.chibbistest.ru/api/v1/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(ChibbisService::class.java)
    }
}