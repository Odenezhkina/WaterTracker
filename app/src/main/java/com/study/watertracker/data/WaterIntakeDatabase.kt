package com.study.watertracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.study.watertracker.data.converters.CalendarConverter
import com.study.watertracker.data.converters.WaterMetricConverter
import com.study.watertracker.data.dao.WaterIntakeDao
import com.study.watertracker.data.entities.DayWaterIntakeEntity


@Database(entities = [DayWaterIntakeEntity::class], version = 1, exportSchema = false)
@TypeConverters(CalendarConverter::class, WaterMetricConverter::class)
abstract class WaterIntakeDatabase : RoomDatabase() {
    abstract fun waterIntakeDao(): WaterIntakeDao

    companion object {
        const val DATABASE_NAME = "water_intake_database"
    }
}
