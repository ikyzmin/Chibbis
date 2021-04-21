package ru.ikuzmin.db.converters

import androidx.room.TypeConverter
import ru.ikuzmin.db.repository.LocalSpecializationName
import ru.ikuzmin.domain.model.SpecializationName


class SpecializationArrayToStringConverter {

    @TypeConverter
    fun fromString(string: String): List<SpecializationName> {
        return string.split(",").map { LocalSpecializationName(it) }
    }

    @TypeConverter
    fun fromList(list: List<SpecializationName>): String {
        return list.map { it.name }.joinToString(",")
    }
}