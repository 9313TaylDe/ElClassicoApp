package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elclassicoapp.data.CompetitionsEntity
import com.example.elclassicoapp.data.DAOCompetitions
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CompetitionViewModel(private val dao: DAOCompetitions) : ViewModel() {
	val allcompetitions = dao.pegarTodos().stateIn(
		viewModelScope,
		SharingStarted.WhileSubscribed(5000),
		initialValue = emptyList<CompetitionsEntity>()
	)
	
	val quantidaderodadas = allcompetitions.map { lista ->
		lista.firstOrNull()?.rounds ?: 0
	}.stateIn(
		viewModelScope,
		SharingStarted.WhileSubscribed(5000),
		initialValue = 0
	)
	
	val totalGoals = allcompetitions.map { goals ->
		goals.firstOrNull()?.totalGoals ?: 0
	}.stateIn(
		viewModelScope,
		SharingStarted.WhileSubscribed(5000),
		initialValue = 0
	)
	
	val totaltodadas = allcompetitions.map { quantidaderodadas ->
		quantidaderodadas.firstOrNull()?.totalRounds ?: 0
	}.stateIn(
		viewModelScope,
		SharingStarted.WhileSubscribed(5000),
		initialValue = 0
	)
	
	
	fun Deletar(competitions: CompetitionsEntity) {
		viewModelScope.launch {
			dao.Deletar(competitions)
		}
	}
	
	fun Inserir(competitions: CompetitionsEntity) {
		viewModelScope.launch {
			dao.Inserir(competitions)
		}
	}
	
	fun Atualizar(competitions: CompetitionsEntity) {
		viewModelScope.launch {
			dao.Inserir(competitions)
		}
	}
	
}