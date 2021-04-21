package ru.ikuzmin.chibbis.routes

interface Route {
    fun tag(): String
    fun name(): String
    fun show()
}