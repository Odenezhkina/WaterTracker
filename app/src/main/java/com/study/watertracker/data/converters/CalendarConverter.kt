package com.study.watertracker.data.converters

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun fromCalendar(calendar: Calendar?): Long? =
        calendar?.timeInMillis


    @TypeConverter
    fun toCalendar(timestamp: Long?): Calendar? =
        timestamp?.let {
            Calendar.getInstance().apply { timeInMillis = timestamp }
        }
}


