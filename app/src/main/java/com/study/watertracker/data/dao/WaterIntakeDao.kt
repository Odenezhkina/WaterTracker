package com.study.watertracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.study.watertracker.data.entities.DayWaterIntakeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterIntakeDao {

    @Insert
    suspend fun insert(item: DayWaterIntakeEntity): Long

    @Update
    suspend fun update(item: DayWaterIntakeEntity)

    @Query("SELECT * FROM water_intakes")
    fun getAll(): Flow<List<DayWaterIntakeEntity>>

    @Query("SELECT * FROM water_intakes WHERE date BETWEEN :dayStart AND :dayEnd")
    suspend fun getByDay(dayStart: Long, dayEnd: Long): DayWaterIntakeEntity?

    @Query("SELECT COUNT(*) FROM water_intakes")
    suspend fun countAll(): Int
}
