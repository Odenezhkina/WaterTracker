package com.study.watertracker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.study.watertracker.domain.model.WaterMetrics
import java.util.*

@Entity(tableName = "water_intakes")
data class DayWaterIntakeEntity(
    @PrimaryKey val id: Long = 0,
    val amount: Float = 0f,
    val metric: WaterMetrics = WaterMetrics.MILLILITRES,
    val date: Calendar = Calendar.getInstance()
)

