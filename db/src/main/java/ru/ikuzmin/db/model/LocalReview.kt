package ru.ikuzmin.db.model

import ru.ikuzmin.domain.model.Review

interface LocalReview : Review {
    val id: Int
}