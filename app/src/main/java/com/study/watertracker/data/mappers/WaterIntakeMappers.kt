package com.study.watertracker.data.mappers

import com.study.watertracker.data.entities.DayWaterIntakeEntity
import com.study.watertracker.domain.model.DayWaterIntake

fun DayWaterIntake.toWaterIntakeEntity() = DayWaterIntakeEntity(
    amount = amount,
    metric = metric,
    date = date
)

fun DayWaterIntakeEntity.toWaterIntake() =
    DayWaterIntake(amount = amount, metric = metric, date = date)
