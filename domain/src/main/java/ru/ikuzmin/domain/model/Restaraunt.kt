package ru.ikuzmin.domain.model


interface Restaraunt {
    val name: String
    val logoURL: String
    val minCost: Int
    val deliveryCost: Int
    val deliveryTime: Int
    val positiveReviewCount: Int
    val reviewCount: Int
    val specialization:List<SpecializationName>
}