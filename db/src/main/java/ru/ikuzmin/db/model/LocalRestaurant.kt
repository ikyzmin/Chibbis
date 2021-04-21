package ru.ikuzmin.db.model

import ru.ikuzmin.domain.model.Restaraunt

interface LocalRestaurant : Restaraunt {
    val id: Int
}