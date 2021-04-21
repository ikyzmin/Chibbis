package ru.ikuzmin.db.converters

import androidx.room.TypeConverter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateStringConverter{

    private val dateFormat = SimpleDateFormat("yyyy-MM-ddTHH:MM:SS",Locale.getDefault())

    @TypeConverter
    fun fromTimestamp(value: String): Date? {
        return dateFormat.parse(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): String {
        return dateFormat.format(date)
    }
}