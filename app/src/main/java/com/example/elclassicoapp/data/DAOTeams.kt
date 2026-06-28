package com.example.elclassicoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOTeams {
	
	@Insert
	suspend fun inserir(team: TeamsEntity)
	
	@Update
	suspend fun atualizar(team: TeamsEntity)
	
	@Delete
	suspend fun deletar(team: TeamsEntity)
	
	@Query("SELECT * FROM TeamsEntity")
	fun pegarTodos(): Flow<List<TeamsEntity>>
}