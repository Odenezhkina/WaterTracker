package com.study.watertracker.presentation.model

import com.study.watertracker.domain.model.WaterIntake

fun WaterIntake.toUiWaterIntake(maxAmount: Float) =
    UiWaterIntake(amount = amount, metric = metric, date = date, maxAmount = maxAmount)

fun UiWaterIntake.toWaterIntake() = WaterIntake(amount = amount, metric = metric, date = date)
