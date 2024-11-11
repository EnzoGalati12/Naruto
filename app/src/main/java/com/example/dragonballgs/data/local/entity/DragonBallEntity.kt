package com.example.dragonballgs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.dragonballgs.domain.model.DragonBall
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "dragon_table")
data class DragonBallEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val images: List<String>
) {
    fun toDragonBall(): DragonBall {
        return DragonBall(
            id = id,
            name = name,
            images = images
        )
    }
}

// TypeConverter para Room
class Converters {
    @TypeConverter
    fun fromListOfStrings(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toListOfStrings(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}

