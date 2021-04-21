package ru.ikuzmin.remote.service

import retrofit2.http.GET
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.domain.model.Review
import ru.ikuzmin.remote.model.RemoteHit
import ru.ikuzmin.remote.model.RemoteRestaurant
import ru.ikuzmin.remote.model.RemoteReview

interface ChibbisService {
        @GET("restaurants")
        suspend fun restaraunts():List<RemoteRestaurant>

        @GET("reviews")
        suspend fun reviews():List<RemoteReview>

        @GET("hits")
        suspend fun hits():List<RemoteHit>
}