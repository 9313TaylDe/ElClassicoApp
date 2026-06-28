package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elclassicoapp.data.DAOCompetitions
import com.example.elclassicoapp.data.DAOTeams

class SecurityFactoryTeams(
	private val team: DAOTeams) :
	ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(TeamViewModel::class.java)) {
			@Suppress("UNCHECKED_CAST")
			return TeamViewModel(team) as T
		}
		throw IllegalArgumentException(
			"Nenhuma viewmodel confiavel disponivel"
		)
	}
}