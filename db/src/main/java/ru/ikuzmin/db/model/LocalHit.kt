package ru.ikuzmin.db.model

import ru.ikuzmin.domain.model.Hit

interface LocalHit: Hit {
    val id:Int
}