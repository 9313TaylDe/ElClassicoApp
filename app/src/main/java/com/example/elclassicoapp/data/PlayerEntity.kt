package com.example.elclassicoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class PlayerEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	val name: String,
	val teamId: Int,
	val goals: Int = 0
)