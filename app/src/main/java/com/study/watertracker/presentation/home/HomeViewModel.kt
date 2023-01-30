package com.study.watertracker.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.watertracker.domain.model.DayWaterIntake
import com.study.watertracker.domain.usecase.WaterUseCases
import com.study.watertracker.util.NotFoundException
import com.study.watertracker.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// current water intake
// update current water intake
@HiltViewModel
class HomeViewModel @Inject constructor(private val waterUseCases: WaterUseCases) : ViewModel() {

    private var _dayWaterIntake: MutableStateFlow<UiState<DayWaterIntake>> =
        MutableStateFlow(UiState.Loading())
    val dayWaterIntake = _dayWaterIntake.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        waterUseCases.getWaterIntakeByDay().distinctUntilChanged().collectLatest { waterIntake ->
            _dayWaterIntake.update {
                waterIntake?.let {
                    UiState.Success(it)
                } ?: UiState.Error(NotFoundException())
            }
        }
    }

    fun onEvent(event: HomeEvent) = viewModelScope.launch {
        when (event) {
            is HomeEvent.AddGlassOfWater ->
                dayWaterIntake.value.data?.let { waterIntake ->
                    val newAmount = waterIntake.amount + waterIntake.metric.standarGlassIntake
                    waterUseCases.updateWaterIntake(waterIntake.copy(amount = newAmount))
                }
            is HomeEvent.TryAgain -> {
                // todo
            }
        }
    }


}
