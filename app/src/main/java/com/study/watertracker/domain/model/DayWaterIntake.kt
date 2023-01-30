package com.study.watertracker.domain.model

import java.util.*

data class DayWaterIntake(
    val amount: Int = 0,
    val metric: WaterMetrics = WaterMetrics.MILLILITRES,
    val date: Calendar = Calendar.getInstance()
)


