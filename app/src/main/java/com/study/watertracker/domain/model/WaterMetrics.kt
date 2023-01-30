package com.study.watertracker.domain.model

import androidx.annotation.StringRes
import com.study.watertracker.R

enum class WaterMetrics(@StringRes val stringResId: Int, val standarGlassIntake: Float) {
    MILLILITRES(R.string.water_metrics_ml, 250f),
    LITRES(R.string.water_metrics_litres, 0.25f)
}
