package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elclassicoapp.data.DAOTeams
import com.example.elclassicoapp.data.TeamsEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TeamViewModel(
	private val dao: DAOTeams,
) : ViewModel() {
	
	val allTeams = dao.pegarTodos().stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(5000),
		initialValue = emptyList<TeamsEntity>()
	)
	val quantidadeTimes = allTeams
		.map { it.size }
		.stateIn(
			scope = viewModelScope,
			started = SharingStarted.WhileSubscribed(5000),
			initialValue = 0
		)
	
		
	fun addTeam(team: TeamsEntity) {
		viewModelScope.launch {
			dao.inserir(team)
		}
	}
	
	fun removeTeam(team: TeamsEntity) {
		viewModelScope.launch {
			dao.deletar(team)
		}
	}
	
	fun updateTeam(team: TeamsEntity) {
		viewModelScope.launch {
			dao.atualizar(team)
		}
	}
}