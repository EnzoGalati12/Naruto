package com.example.dragonballgs.domain.usecase

import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.repository.DragonBallRepository

class DeleteItemHistoryUseCase (private val repository: DragonBallRepository){
    suspend operator fun invoke(dragonBall: Long) {
        return repository.deleteItemHistory(dragonBall)
    }
}