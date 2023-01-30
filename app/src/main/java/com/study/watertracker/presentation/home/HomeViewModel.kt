package com.study.watertracker.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.watertracker.domain.model.DayWaterIntake
import com.study.watertracker.domain.usecase.WaterUseCases
import com.study.watertracker.util.NotFoundException
import com.study.watertracker.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// current water intake
// update current water intake
@HiltViewModel
class HomeViewModel @Inject constructor(private val waterUseCases: WaterUseCases) : ViewModel() {

    private var _dayWaterIntake: MutableStateFlow<State<DayWaterIntake>> =
        MutableStateFlow(State.Loading())
    val dayWaterIntake = _dayWaterIntake.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        waterUseCases.getWaterIntakeByDay().distinctUntilChanged().collectLatest { waterIntake ->
            _dayWaterIntake.update {
                waterIntake?.let {
                    State.Success(it)
                } ?: State.Error(NotFoundException())
            }
        }
    }

    fun addWater() = viewModelScope.launch {
        dayWaterIntake.value.data?.let { waterIntake ->
            val newAmount = waterIntake.amount + waterIntake.metric.standarGlassIntake
            waterUseCases.updateWaterIntake(waterIntake.copy(amount = newAmount))
        }
    }

}
