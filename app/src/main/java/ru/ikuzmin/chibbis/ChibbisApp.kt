package ru.ikuzmin.chibbis

import android.app.Application
import androidx.room.Room
import ru.ikuzmin.db.ChibbisDatabase
import ru.ikuzmin.db.dao.HitsDao
import ru.ikuzmin.db.dao.RestaurantsDao
import ru.ikuzmin.db.dao.ReviewsDao

class ChibbisApp : Application() {

    companion object {
        lateinit var instance: ChibbisApp
    }

    lateinit var chibbisDatabase: ChibbisDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this
        chibbisDatabase = Room.databaseBuilder(
            this,
            ChibbisDatabase::class.java,
            ChibbisDatabase::class.java.getSimpleName()
        ).build()
    }

    fun restaurantsDao(): RestaurantsDao {
        return chibbisDatabase.restaurantsDao()
    }

    fun hitsDao(): HitsDao {
        return chibbisDatabase.hitsDao()
    }

    fun reviewsDao(): ReviewsDao {
        return chibbisDatabase.reviewsDao()
    }
}