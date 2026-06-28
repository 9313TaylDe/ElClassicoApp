package com.example.elclassicoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOCompetitions {
	@Insert
	suspend fun Inserir(competitions: Competitions)
	
	@Delete
	suspend fun Deletar(competitions: Competitions)
	
	@Update
	suspend fun Atualizar(competitions: Competitions)
	
	@Query("SELECT * FROM Competitions")
	fun pegarTodos(): Flow<List<Competitions>>
}