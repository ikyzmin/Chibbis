package ru.ikuzmin.domain.model

interface Review {
    val isPositive:Boolean
    val message:String
    val userName:String
    val restarauntName:String
    val data:String
}