package com.study.watertracker.domain.model

import androidx.annotation.StringRes
import com.study.watertracker.R

enum class WaterMetrics(@StringRes val stringResId: Int) {
    MILLILITRES(R.string.water_metrics_ml), LITRES(R.string.water_metrics_litres)
}
