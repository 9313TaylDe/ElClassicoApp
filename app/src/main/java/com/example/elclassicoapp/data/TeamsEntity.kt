package com.example.elclassicoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TeamsEntity
	(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	val teamTitle: String,
	val logoCompetition: Int,
	val isfinished: Boolean = false,
	val competitions: Competitions
)