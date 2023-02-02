package com.study.watertracker.data.mappers

import com.study.watertracker.data.model.WaterIntakeEntity
import com.study.watertracker.domain.model.WaterIntake

fun WaterIntake.toWaterIntakeEntity() = WaterIntakeEntity(
    amount = amount,
    metric = metric,
    date = date
)

fun WaterIntakeEntity.toWaterIntake() =
    WaterIntake(amount = amount, metric = metric, date = date)
