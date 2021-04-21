package ru.ikuzmin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ikuzmin.db.dao.HitsDao
import ru.ikuzmin.db.dao.RestaurantsDao
import ru.ikuzmin.db.dao.ReviewsDao

@Database(entities = [
    DbRestaraunt::class,
    DbHit::class,
    DbReview::class ], version = 1)
abstract class ChibbisDatabase : RoomDatabase() {

    abstract fun restaurantsDao(): RestaurantsDao
    abstract fun hitsDao(): HitsDao
    abstract fun reviewsDao(): ReviewsDao
}