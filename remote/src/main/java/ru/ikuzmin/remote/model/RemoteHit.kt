package ru.ikuzmin.remote.model

import com.google.gson.annotations.SerializedName
import ru.ikuzmin.domain.model.Hit

data class RemoteHit(
    @SerializedName("ProductName")
    override val productName: String,
    @SerializedName("ProductImage")
    override val productImageURL: String,
    @SerializedName("ProductPrice")
    override val price: Int,
    @SerializedName("ProductDescription")
    override val description: String,
    @SerializedName("RestaurantId")
    override val restarauntId: Int,
    @SerializedName("RestaurantName")
    override val restarauntName: String,
    @SerializedName("RestaurantLogo")
    override val restarauntLogoURL: String
) :Hit

