package com.example.elclassicoapp.repository

import androidx.room.TypeConverter
import com.example.elclassicoapp.data.Competitions
import com.google.gson.Gson


class Converters {
	@TypeConverter
	fun fromCompetition(competitions: Competitions): String {
		return Gson().toJson(competitions)
	}
	
	
	@TypeConverter
	fun toCompetition(data: String): Competitions{
		return Gson().fromJson(data, Competitions::class.java)
	}
}