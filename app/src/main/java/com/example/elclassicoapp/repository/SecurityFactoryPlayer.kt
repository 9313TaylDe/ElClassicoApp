package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elclassicoapp.data.DAOPlayer
import com.example.elclassicoapp.data.PlayerViewModel

class SecurityFactoryPlayer(private val daoPlayer: DAOPlayer) : ViewModelProvider.Factory {
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel>
			create(modelPlayer: Class<T>): T {
		if (modelPlayer.isAssignableFrom(PlayerViewModel::class.java)) {
			return PlayerViewModel(daoPlayer) as T
		}
		throw IllegalArgumentException("")
	}
}

//ATUALIZAÇÃO 2.0