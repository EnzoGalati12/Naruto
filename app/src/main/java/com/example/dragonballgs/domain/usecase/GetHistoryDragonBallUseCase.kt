package com.example.dragonballgs.domain.usecase

import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.repository.DragonBallRepository

class GetHistoryDragonBallUseCase (private val repository: DragonBallRepository){
    suspend operator fun invoke(): List<DragonBall> {
        return repository.getHistoryDragonBall()
    }
}