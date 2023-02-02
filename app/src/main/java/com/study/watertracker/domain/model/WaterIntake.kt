package com.study.watertracker.domain.model

import java.util.*

data class WaterIntake(
    val amount: Float = 0f,
    val metric: WaterMetrics = WaterMetrics.MILLILITRES,
    val date: Calendar = Calendar.getInstance()
)


