package com.example.elclassicoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.elclassicoapp.repository.Converters

@Database(
	entities = [TeamsEntity::class],
	exportSchema = false,
	version = 1
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
	
	abstract fun getAll(): DAOTeams
}