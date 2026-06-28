package com.example.elclassicoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Competitions(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	val name: String,
	val times: Int,
	val rounds: Int,
	val totalRounds: Int,
	val matches: Int,
	val isFinished: Boolean = false
)