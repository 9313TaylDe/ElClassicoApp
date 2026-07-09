package com.example.elclassicoapp.repository

import androidx.room.TypeConverter
import com.example.elclassicoapp.data.CompetitionsEntity
import com.google.gson.Gson


class Converters {
	@TypeConverter
	fun fromCompetition(competitions: CompetitionsEntity): String {
		return Gson().toJson(competitions)
	}
	
	
	@TypeConverter
	fun toCompetition(data: String): CompetitionsEntity{
		return Gson().fromJson(data, CompetitionsEntity::class.java)
	}
}