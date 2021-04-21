package ru.ikuzmin.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.ikuzmin.db.model.LocalHit

@Entity(tableName = "Hit")
class DbHit : LocalHit {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0

    override var productName: String = ""
    override var productImageURL: String = ""
    override var price: Int = 0
    override var description: String = ""
    override var restarauntId: Int = 0
    override var restarauntName: String = ""
    override var restarauntLogoURL: String = ""
}