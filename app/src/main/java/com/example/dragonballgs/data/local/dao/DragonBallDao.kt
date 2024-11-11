package com.example.dragonballgs.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dragonballgs.data.local.entity.DragonBallEntity

@Dao
interface DragonBallDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDragonBall(dragonBall: DragonBallEntity)

    @Query("SELECT * FROM dragon_table WHERE id = :id LIMIT 1")
    suspend fun getDragonBall(id: Long): DragonBallEntity?

    @Query("SELECT * FROM dragon_table")
    suspend fun getHistoryDragonBalls(): List<DragonBallEntity>

    @Delete
    suspend fun delete(dragonBall: DragonBallEntity)

    @Query("DELETE FROM dragon_table")
    suspend fun deleteAll()
}