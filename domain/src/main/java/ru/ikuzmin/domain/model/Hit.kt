package ru.ikuzmin.domain.model

interface Hit {
    val productName:String
    val productImageURL:String
    val price:Int
    val description:String
    val restarauntId:Int
    val restarauntName:String
    val restarauntLogoURL:String
}