package ru.ikuzmin.remote.model

import com.google.gson.annotations.SerializedName
import ru.ikuzmin.domain.model.Restaraunt

data class RemoteRestaurant(
    @SerializedName("Name")
    override val name: String,
    @SerializedName("Logo")
    override val logoURL: String,
    @SerializedName("MinCost")
    override val minCost: Int,
    @SerializedName("DeliveryCost")
    override val deliveryCost: Int,
    @SerializedName("DeliveryTime")
    override val deliveryTime: Int,
    @SerializedName("PositiveReviews")
    override val positiveReviewCount: Int,
    @SerializedName("ReviewsCount")
    override val reviewCount: Int,
    @SerializedName("Specializations")
    override val specialization: List<RemoteSpecializationName>
) :Restaraunt