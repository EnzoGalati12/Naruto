package com.example.dragonballgs.domain.usecase

import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.repository.DragonBallRepository

class DeleteAllHistoryUseCase (private val repository: DragonBallRepository){
    suspend operator fun invoke() {
        return repository.deleteAllHistory()
    }
}