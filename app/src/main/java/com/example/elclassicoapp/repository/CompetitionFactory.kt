package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elclassicoapp.data.DAOCompetitions

class CompetitionFactory(private val dao: DAOCompetitions) : ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(CompetitionViewModel::class.java)) {
			return CompetitionViewModel(dao) as T
		}
		throw IllegalArgumentException(
			"Nenhuma viewmodel confiavel disponivel"
		)
	}
}