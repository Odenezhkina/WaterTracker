package com.study.watertracker.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.watertracker.domain.usecase.WaterUseCases
import com.study.watertracker.presentation.model.UiWaterIntake
import com.study.watertracker.presentation.model.toUiWaterIntake
import com.study.watertracker.presentation.model.toWaterIntake
import com.study.watertracker.util.NotFoundException
import com.study.watertracker.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// current water intake
// update current water intake
@HiltViewModel
class HomeViewModel @Inject constructor(private val waterUseCases: WaterUseCases) : ViewModel() {

    // flow to check updates when user add more water
    private var _dayWaterIntake: MutableStateFlow<UiState<UiWaterIntake>> =
        MutableStateFlow(UiState.Loading())
    val dayWaterIntake = _dayWaterIntake.asStateFlow()

    private var observerWaterJob: Job? = null

    init {
        loadData()
    }

    private fun loadData() {
        observerWaterJob?.cancel()
        observerWaterJob = viewModelScope.launch {
            waterUseCases.getWaterIntakeByDay().distinctUntilChanged()
                .collectLatest { waterIntake ->
                    // todo get max amount and map to UiWaterIntake
                    _dayWaterIntake.update {
                        waterIntake?.let {
                            UiState.Success(it.toUiWaterIntake(900f))
                        } ?: UiState.Error(NotFoundException())
                    }
                }
        }
    }

    fun onEvent(event: HomeEvent) = viewModelScope.launch {
        when (event) {
            is HomeEvent.AddGlassOfWater ->
                dayWaterIntake.value.data?.let { uiWaterIntake ->
                    // todo get standard water intake per glass from some store idk
                    val newAmount = uiWaterIntake.amount + 200f
                    waterUseCases.updateWaterIntake(
                        uiWaterIntake.copy(amount = newAmount).toWaterIntake()
                    )
                }
            is HomeEvent.TryAgain -> loadData()
        }
    }


}
