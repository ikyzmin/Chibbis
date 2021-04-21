package ru.ikuzmin.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.ikuzmin.db.converters.DateStringConverter
import ru.ikuzmin.db.model.LocalReview
import ru.ikuzmin.domain.model.Review
import java.util.*

@Entity(tableName = "Review")
@TypeConverters(DateStringConverter::class)
class DbReview : LocalReview {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
    override var isPositive: Boolean = false
    override var message: String = ""
    override var userName: String = ""
    override var restarauntName: String = ""
    override var data: String =""
}