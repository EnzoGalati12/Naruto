package com.example.dragonballgs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dragonballgs.data.local.dao.DragonBallDao
import com.example.dragonballgs.data.local.entity.Converters
import com.example.dragonballgs.data.local.entity.DragonBallEntity

@Database(entities = [DragonBallEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dragonBallDao(): DragonBallDao
}