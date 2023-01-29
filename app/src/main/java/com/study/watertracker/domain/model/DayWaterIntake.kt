package com.study.watertracker.domain.model

import androidx.annotation.StringRes
import com.study.watertracker.R
import java.util.*

data class DayWaterIntake(
    val amount: Int = 0,
    val metric: WaterMetrics = WaterMetrics.MILLILITRES,
    val date: Calendar
)

enum class WaterMetrics(@StringRes val stringResId: Int) {
    MILLILITRES(R.string.water_metrics_ml), LITRES(R.string.water_metrics_litres)
}
