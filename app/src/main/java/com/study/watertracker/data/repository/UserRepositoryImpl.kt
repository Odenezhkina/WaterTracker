package com.study.watertracker.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.study.watertracker.domain.model.ActivityLevel
import com.study.watertracker.domain.model.UserInfo.Companion.DEFAULT_ACTIVITY_LEVEL
import com.study.watertracker.domain.model.UserInfo.Companion.DEFAULT_GENDER
import com.study.watertracker.domain.model.UserInfo.Companion.DEFAULT_WEIGHT
import com.study.watertracker.domain.repository.UserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(@ApplicationContext private val context: Context) : UserRepository {
    override suspend fun getGender(): Boolean =
        context.dataStore.data.map { preferences ->
            preferences[GENDER_KEY]
                ?: DEFAULT_GENDER
        }.first()

    override suspend fun saveGender(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[GENDER_KEY] = value
        }
    }

    override suspend fun getWeight(): Int =
        context.dataStore.data.map { preferences ->
            preferences[WEIGHT_KEY]
                ?: DEFAULT_WEIGHT
        }.first()

    override suspend fun saveWeight(value: Int) {
        context.dataStore.edit { preferences ->
            preferences[WEIGHT_KEY] = value
        }
    }

    override suspend fun getActivityLevel(): ActivityLevel =
        context.dataStore.data.map { preferences ->
            val activityLevelName = preferences[ACTIVITY_LEVEL_KEY]
            ActivityLevel.values().find { it.name == activityLevelName }
        }.first() ?: DEFAULT_ACTIVITY_LEVEL


    override suspend fun saveActivityLevel(activityLevel: ActivityLevel) {
        context.dataStore.edit { preferences ->
            preferences[ACTIVITY_LEVEL_KEY] = activityLevel.name
        }
    }

    companion object {
        private const val DATA_STORE_NAME = "user info"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            DATA_STORE_NAME
        )
        private val GENDER_KEY = booleanPreferencesKey("gender")
        private val ACTIVITY_LEVEL_KEY = stringPreferencesKey("activity level")
        private val WEIGHT_KEY = intPreferencesKey("weight")
    }
}
