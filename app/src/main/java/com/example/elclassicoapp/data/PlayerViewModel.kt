package com.example.elclassicoapp.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class PlayerViewModel (private val daoPlayer: DAOPlayer): ViewModel(){
	fun getPlayer() = daoPlayer.getTopScorer().stateIn(
		viewModelScope,
		SharingStarted.WhileSubscribed(500),
		initialValue = PlayerEntity(
			id = 0,
			teamId = 0,
			goals = 10,
			name = "Messi"
		)
		//ATUALZAÇÃO 2.0
	)
}