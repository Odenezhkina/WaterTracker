package com.study.watertracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.study.watertracker.data.model.WaterIntakeEntity.Companion.TABLE_MANE
import com.study.watertracker.domain.model.WaterMetrics
import java.util.*

@Entity(tableName = TABLE_MANE)
data class WaterIntakeEntity(
    @PrimaryKey val id: Long = 0,
    val amount: Float,
    val metric: WaterMetrics,
    val date: Calendar
) {
    companion object {
        const val TABLE_MANE = "water_intakes"
    }
}

