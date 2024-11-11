package com.example.dragonballgs.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.usecase.GetDragonBallUseCase
import kotlinx.coroutines.launch

class DetalheViewModel(private val getDragonBallUseCase: GetDragonBallUseCase) : ViewModel() {

    private val _dragonData = MutableLiveData<DragonBall>()
    val dragonData: LiveData<DragonBall> get() = _dragonData

    fun fetchDragon(id: Long) {
        viewModelScope.launch {
            val result = getDragonBallUseCase(id)
            _dragonData.value = result
        }
    }
}