package com.example.elclassicoapp.data


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.elclassicoapp.R
import com.example.elclassicoapp.routes.Rotas
import com.example.elclassicoapp.ui.colors.*

sealed class Actions(
	val text: String,
	val icon: ImageVector?,
	val iconRes: Int? = null,
	val route: String,
	val color: Color
) {
	data object HOME : Actions(
		text = "",
		icon = Icons.Default.Home,
		route = Rotas.HOME,
		color = RoxoClaro
	)
	
	data object new_camp : Actions(
		text = "Novo campeonato",
		icon = Icons.Default.AddCircleOutline,
		route = Rotas.NEW_CAMP,
		color = Verde
	)
	
	data object teams : Actions(
		text = "Times",
		icon = Icons.Default.Group,
		route = Rotas.ALL_TEAMS,
		color = AzulClaro
	)
	
	data object matches : Actions(
		text = "Partidas",
		icon = Icons.Default.CalendarMonth,
		route = Rotas.MATCHES,
		color = RoxoClaro
	)
	
	data object ranking : Actions(
		text = "Ranking",
		icon = Icons.Default.EmojiEvents,
		route = Rotas.HOME,
		color = laraanjaa
	)
	
	data object Brasileriao : Actions(
		text = "Brasileirão",
		icon = null,
		iconRes = R.drawable.brasileirao,
		route = Rotas.HOME,
		color = VerdeClaro
	)
	
	data object ChampionsLeague : Actions(
		text = "Champions\nLeague",
		icon = null,
		iconRes = R.drawable.champions,
		route = Rotas.HOME,
		color = Color.White
	)
	
	data object CopaDoMundo : Actions(
		text = "Copa do Mundo",
		icon = null,
		iconRes = R.drawable.worldcupo,
		route = Rotas.HOME,
		color = amarelo
	)
	
	data object CopaNacional : Actions(
		text = "Copa\nNacional",
		icon = null,
		iconRes = R.drawable.brasileirao,
		route = Rotas.HOME,
		color = VerdeClaro
	)
}