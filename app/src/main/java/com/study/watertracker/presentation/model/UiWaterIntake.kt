package com.study.watertracker.presentation.model

import com.study.watertracker.domain.model.WaterMetrics
import java.util.*

data class UiWaterIntake(
    val amount: Float,
    val metric: WaterMetrics,
    val date: Calendar = Calendar.getInstance(),
    val maxAmount: Float
)
