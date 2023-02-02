package com.study.watertracker.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.study.watertracker.domain.model.WaterMetrics
import com.study.watertracker.domain.repository.UserSettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserSettingsRepositoryImpl(@ApplicationContext private val context: Context) :
    UserSettingsRepository {
    override fun getDailyWaterIntake(): Flow<Float> = context.dataStore.data.map { preferences ->
            preferences[DAILY_WATER_INTAKE_KEY] ?: DEFAULT_WATER_INTAKE
        }


    override suspend fun saveDailyWaterIntake(value: Float) {
        context.dataStore.edit { preferences ->
            preferences[DAILY_WATER_INTAKE_KEY] = value
        }
    }

    override fun getWaterMetrics(): Flow<WaterMetrics> =
        context.dataStore.data
            .map { preferences ->
                preferences[WATER_METRICS_KEY]?.let { metric ->
                    WaterMetrics.values().find { it.name == metric }
                } ?: DEFAULT_WATER_METRIC
            }

    override suspend fun saveWaterMetrics(waterMetrics: WaterMetrics) {
        context.dataStore.edit { preferences ->
            preferences[WATER_METRICS_KEY] = waterMetrics.name
        }
    }

    override fun getWaterIntakePerGlass(): Flow<Float> =
        context.dataStore.data
            .map { preferences ->
                preferences[GLASS_INTAKE_KEY] ?: DEFAULT_GLASS_INTAKE
            }

    override suspend fun saveWaterIntakePerGlass(value: Float) {
        context.dataStore.edit { preferences ->
            preferences[GLASS_INTAKE_KEY] = value
        }
    }

    companion object {
        private const val DATA_STORE_NAME = "user settings"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            DATA_STORE_NAME
        )
        private val DAILY_WATER_INTAKE_KEY = floatPreferencesKey("daily water intake")
        private val WATER_METRICS_KEY = stringPreferencesKey("water metrics")
        private val GLASS_INTAKE_KEY = floatPreferencesKey("water per glass")
        private const val DEFAULT_WATER_INTAKE = 2500f
        private val DEFAULT_WATER_METRIC = WaterMetrics.MILLILITRES
        private const val DEFAULT_GLASS_INTAKE = 200f
    }
}
