package com.example.elclassicoapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.elclassicoapp.ui.colors.Azul
import com.example.elclassicoapp.ui.colors.Verde
import com.example.elclassicoapp.ui.colors.laraanjaa

sealed class Statistics(
	val title: String = "",
	val icon: ImageVector,
	val color: Color
) {
	
	data object ConcluedMatches : Statistics(
		title = "Partidas realizadas",
		icon = Icons.Default.Event,
		color = Verde
	)
	
	data object TotalGoals : Statistics(
		title = "Gols marcados",
		icon = Icons.Default.SportsSoccer,
		color = Azul
	)
	
	
	data object TopScorer : Statistics(
		title = "Artilheiro",
		icon = Icons.Default.StarOutline,
		color = laraanjaa
	)
}