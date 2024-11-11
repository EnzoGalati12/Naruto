package com.example.dragonballgs.data.remote.api

import com.example.dragonballgs.data.remote.model.DragonBallResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallService {
    @GET("character/{id}")
    suspend fun getDragonBall(@Path("id") id: Long): DragonBallResponse
}