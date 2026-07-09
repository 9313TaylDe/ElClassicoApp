package com.example.elclassicoapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elclassicoapp.data.DAOPlayer
import com.example.elclassicoapp.data.PlayerViewModel

class SecurityFactoryPlaye(
	private val daoPlayer: DAOPlayer
) : ViewModelProvider.Factory {
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel> create(playermodel: Class<T>): T {
		if(playermodel.isAssignableFrom(PlayerViewModel::class.java)){
			return PlayerViewModel(daoPlayer) as T
			
		}
		throw IllegalArgumentException("")
	}
}

//	override fun <T : ViewModel> create(modelClass: Class<T>): T {
//
//		if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
//			return PlayerViewModel(daoPlayer) as T
//		}
//
//		throw IllegalArgumentException("Unknown ViewModel class")
//	}
//}