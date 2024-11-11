package com.example.dragonballgs.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.usecase.DeleteAllHistoryUseCase
import com.example.dragonballgs.domain.usecase.DeleteItemHistoryUseCase
import com.example.dragonballgs.domain.usecase.GetHistoryDragonBallUseCase
import kotlinx.coroutines.launch

class DragonBallViewModel(
    private val getHistoryDragonBallUseCase: GetHistoryDragonBallUseCase,
    private val deleteItemHistoryUseCase: DeleteItemHistoryUseCase,
    private val deleteAllHistoryUseCase: DeleteAllHistoryUseCase
) : ViewModel() {

    private val _dragonAllHistory = MutableLiveData<List<DragonBall>>()
    val dragonAllHistory: LiveData<List<DragonBall>> get() = _dragonAllHistory

    fun getHistory() {
        viewModelScope.launch {
            val result = getHistoryDragonBallUseCase()
            _dragonAllHistory.value = result
        }
    }

    fun delete(dragon: Long) {
        viewModelScope.launch {
            deleteItemHistoryUseCase(dragon)
            getHistory()
        }
    }


    fun deleteAll() {
        viewModelScope.launch {
            deleteAllHistoryUseCase()

        }
    }

}