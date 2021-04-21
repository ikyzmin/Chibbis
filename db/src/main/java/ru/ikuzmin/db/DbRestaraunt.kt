package ru.ikuzmin.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.ikuzmin.db.converters.DateStringConverter
import ru.ikuzmin.db.converters.SpecializationArrayToStringConverter
import ru.ikuzmin.db.model.LocalRestaurant
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.domain.model.SpecializationName

@Entity(tableName = "Restaurant")
@TypeConverters(SpecializationArrayToStringConverter::class)
class DbRestaraunt : LocalRestaurant {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
    override var name: String = ""
    override var logoURL: String = ""
    override var minCost: Int = 0
    override var deliveryCost: Int = 0
    override var deliveryTime: Int = 0
    override var positiveReviewCount: Int = 0
    override var reviewCount: Int = 0
    override var specialization: List<SpecializationName> = emptyList()
}