package com.study.watertracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.study.watertracker.data.model.WaterIntakeEntity
import com.study.watertracker.data.model.WaterIntakeEntity.Companion.TABLE_MANE
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterIntakeDao {

    @Insert
    suspend fun insert(item: WaterIntakeEntity): Long

    @Update
    suspend fun update(item: WaterIntakeEntity)

    @Query("SELECT * FROM $TABLE_MANE")
    fun getAll(): Flow<List<WaterIntakeEntity>>

    @Query("SELECT * FROM $TABLE_MANE WHERE date BETWEEN :dayStart AND :dayEnd")
    fun getByDay(dayStart: Long, dayEnd: Long): Flow<WaterIntakeEntity?>

    @Query("SELECT COUNT(*) FROM $TABLE_MANE")
    suspend fun countAll(): Int
}
