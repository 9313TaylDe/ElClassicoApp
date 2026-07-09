package com.example.elclassicoapp.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOPlayer {
	
	@Query("SELECT * FROM PlayerEntity ORDER BY goals DESC LIMIT 1")
	fun getTopScorer(): Flow<PlayerEntity>
	
	
	
}