package com.study.watertracker.di

import android.app.Application
import androidx.room.Room
import com.study.watertracker.data.WaterIntakeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesWaterIntakeDatabase(app: Application): WaterIntakeDatabase =
        Room.databaseBuilder(app, WaterIntakeDatabase::class.java, WaterIntakeDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesWaterIntakeDao(database: WaterIntakeDatabase) = database.waterIntakeDao()

}
