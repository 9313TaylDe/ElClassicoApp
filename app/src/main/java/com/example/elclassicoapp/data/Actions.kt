package com.example.elclassicoapp.data


//import compose.icons.FontAwesomeIcons
//import compose.icons.fontawesomeicons.solid.Futbol
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.elclassicoapp.R
import com.example.elclassicoapp.routes.Rotas
import com.example.elclassicoapp.ui.colors.AzulClaro
import com.example.elclassicoapp.ui.colors.RoxoClaro
import com.example.elclassicoapp.ui.colors.Verde
import com.example.elclassicoapp.ui.colors.VerdeClaro
import com.example.elclassicoapp.ui.colors.amarelo
import com.example.elclassicoapp.ui.colors.laraanjaa

sealed class Actions(
	val text: String,
	val icon: ImageVector?,
	val iconRes: Int? = null,
	val route: String,
	val color: Color,
) {
	data object HOME : Actions(
		text = "Home",
		icon = Icons.Default.Home,
		route = Rotas.HOME,
		color = RoxoClaro
	)
	
	data object NEW_CAMP : Actions(
		text = "Novo\nCampeonato",
		icon = Icons.Default.AddCircleOutline,
		route = Rotas.NEW_CAMP,
		color = Verde
	)
	
	data object TEAMS : Actions(
		text = "Times",
		icon = Icons.Default.Group,
		route = Rotas.ALL_TEAMS,
		color = AzulClaro
	)
	
	data object MATCHES : Actions(
		text = "Partidas",
		icon = Icons.Default.CalendarMonth,
		route = Rotas.MATCHES,
		color = RoxoClaro
	)
	
	data object RANKING : Actions(
		text = "Ranking",
		icon = Icons.Default.EmojiEvents,
		route = Rotas.HOME,
		color = laraanjaa
	)
	
	data object BRASILEIRAO : Actions(
		text = "Brasileirão",
		icon = null,
		iconRes = R.drawable.brasileirao,
		route = Rotas.HOME,
		color = VerdeClaro
	)
	
	data object CHAMPIONSLEAGUE : Actions(
		text = "Liga dos\nCampeões",
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
		text = "Copa Nacional",
		icon = null,
		iconRes = R.drawable.brasileirao,
		route = Rotas.HOME,
		color = VerdeClaro
	)

	data object Campeonatos : Actions(
		text = "Campeonatos",
		icon = Icons.Default.EmojiEvents,
		iconRes = null,
		route = Rotas.NEW_CAMP,
		color = VerdeClaro
	)
	data object MatchesHome : Actions(
		text = "Partidas",
		icon = Icons.Default.SportsSoccer,
		iconRes = null,
		route = Rotas.HOME,
		color = VerdeClaro
	)
	data object Estatisticas : Actions(
		text = "Estatisticas",
		icon = Icons.Default.BarChart,
		iconRes = null,
		route = Rotas.HOME,
		color = VerdeClaro
	)
	data object Configuracoes : Actions(
		text = "Configurações",
		icon = Icons.Default.Settings,
		iconRes = null,
		route = Rotas.HOME,
		color = VerdeClaro
	)

}

