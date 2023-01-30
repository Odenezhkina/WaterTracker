package com.study.watertracker.data.converters

import androidx.room.TypeConverter
import com.study.watertracker.domain.model.WaterMetrics

class WaterMetricConverter {

    @TypeConverter
    fun fromWaterMetrics(metrics: WaterMetrics): String {
        return metrics.name
    }

    @TypeConverter
    fun toWaterMetrics(data: String): WaterMetrics? {
        return WaterMetrics.values().find { it.name == data }
    }
}
