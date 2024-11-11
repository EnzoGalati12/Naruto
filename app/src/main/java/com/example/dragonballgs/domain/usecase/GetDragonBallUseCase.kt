package com.example.dragonballgs.domain.usecase

import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.repository.DragonBallRepository

class GetDragonBallUseCase (private val repository: DragonBallRepository){

    suspend operator fun invoke(dragonBall: Long): DragonBall {
        return repository.getDragonBall(dragonBall)
    }
}