package com.example.dragonballgs.data.remote.model

import com.example.dragonballgs.data.local.entity.DragonBallEntity
import com.example.dragonballgs.domain.model.DragonBall
data class DragonBallResponse(
    val id: Long,
    val name: String,
    val images: List<String>, // Atualizado para ser uma lista
) {
    fun toDragonBall(): DragonBall {
        return DragonBall(
            id = id,
            name = name,
            images = images, // Passa a lista de imagens

        )
    }

    fun toDragonBallEntity(): DragonBallEntity {
        return DragonBallEntity(
            id = id,
            name = name,
            images = images, // Passa a lista de imagens

        )
    }
}
