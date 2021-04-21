package ru.ikuzmin.remote.model

import com.google.gson.annotations.SerializedName
import ru.ikuzmin.domain.model.Review

data class RemoteReview(
    @SerializedName("IsPositive")
    override val isPositive: Boolean,
    @SerializedName("Message")
    override val message: String,
    @SerializedName("UserFIO")
    override val userName: String,
    @SerializedName("RestaurantName")
    override val restarauntName: String,
    @SerializedName("DateAdded")
    override val data: String
) :Review
