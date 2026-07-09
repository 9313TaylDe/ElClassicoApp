package com.example.elclassicoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOCompetitions {
	@Insert
	suspend fun Inserir(competitions: CompetitionsEntity)
	
	@Delete
	suspend fun Deletar(competitions: CompetitionsEntity)
	
	@Update
	suspend fun Atualizar(competitions: CompetitionsEntity)
	
	@Query("SELECT * FROM CompetitionsEntity")
	fun pegarTodos(): Flow<List<CompetitionsEntity>>
}