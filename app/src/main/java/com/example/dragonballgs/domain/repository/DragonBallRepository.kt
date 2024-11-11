package com.example.dragonballgs.domain.repository

import com.example.dragonballgs.domain.model.DragonBall

interface DragonBallRepository {

    suspend fun getDragonBall(dragonBall: Long): DragonBall

    suspend fun getHistoryDragonBall(): List<DragonBall>

    suspend fun deleteItemHistory(dragonBall: Long)

    suspend fun deleteAllHistory()
}