package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.DayWaterIntake
import java.util.*

interface WaterRepository {
    fun getAll(): List<DayWaterIntake>

    fun getByDate(calendar: Calendar): DayWaterIntake?

    fun getCountOfAll(): List<DayWaterIntake>
}
