package com.example.elclassicoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.elclassicoapp.data.Actions
import com.example.elclassicoapp.data.CompetitionsEntity
import com.example.elclassicoapp.data.DAOCompetitions
import com.example.elclassicoapp.data.DAOPlayer
import com.example.elclassicoapp.data.DAOTeams
import com.example.elclassicoapp.data.PlayerEntity
import com.example.elclassicoapp.data.PlayerViewModel
import com.example.elclassicoapp.data.Statistics
import com.example.elclassicoapp.data.TeamsEntity
import com.example.elclassicoapp.repository.CompetitionFactory
import com.example.elclassicoapp.repository.CompetitionViewModel
import com.example.elclassicoapp.repository.SecurityFactoryPlaye
import com.example.elclassicoapp.repository.SecurityFactoryTeams
import com.example.elclassicoapp.repository.TeamViewModel
import com.example.elclassicoapp.ui.colors.GrayBlue
import com.example.elclassicoapp.ui.colors.borderCardsMini
import com.example.elclassicoapp.ui.colors.fundoPai
import com.example.elclassicoapp.ui.colors.fundocardpill
import com.example.elclassicoapp.ui.colors.verdetext
import com.example.elclassicoapp.ui.components.PostingCard
import com.example.elclassicoapp.ui.components.StattisticsCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(
	teamViewModel: TeamViewModel,
	competitionViewModel: CompetitionViewModel,
	playerViewModel: PlayerViewModel,
	add: () -> Unit,
	viewClassification: () -> Unit,
	randomTeams: () -> Unit,
) {
	
	val action = listOf(
		Actions.NEW_CAMP,
		Actions.TEAMS,
		Actions.MATCHES,
		Actions.RANKING,
	)
	val recentschampionship = listOf(
		Actions.BRASILEIRAO,
		Actions.CHAMPIONSLEAGUE,
		Actions.CopaDoMundo,
		Actions.CopaNacional,
	)
	
	val navigateBottom = listOf(
		Actions.HOME,
		Actions.Campeonatos,
		Actions.MatchesHome,
		Actions.Estatisticas,
		Actions.Configuracoes
	)
	val statistics = listOf(
		Statistics.ConcluedMatches,
		Statistics.TotalGoals,
		Statistics.TopScorer,
	)
	
	val modi = Modifier
	val qtd by teamViewModel.quantidadeTimes.collectAsStateWithLifecycle()
	val rounds by competitionViewModel.quantidaderodadas.collectAsStateWithLifecycle()
	val roundsTotal by competitionViewModel.totaltodadas.collectAsStateWithLifecycle()
	val goals by competitionViewModel.totalGoals.collectAsStateWithLifecycle()
	val poacher by playerViewModel.getPlayer().collectAsStateWithLifecycle() //ATUALIZAÇÃO 2.0
	val championship: CompetitionsEntity
	Scaffold(
		containerColor = fundoPai,
		topBar = {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Icon(
					imageVector = Icons.Default.Menu, tint = Color.White, contentDescription = ""
				)
				Icon(
					imageVector = Icons.Default.PersonPin, tint = Color.White, contentDescription = ""
				)
			}
		},
		bottomBar = {
			navigateBottom.forEach { itemnav ->
				Row() {
					Column() {
					
					}
				}
			}
			
		},
		modifier = Modifier
			.fillMaxSize()
			.background(fundoPai)
			.statusBarsPadding()
			.padding(10.dp)
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
		) {
			Spacer(Modifier.height(15.dp))
			Text(
				"Bem-Vindo!",
				color = Color.White
			)
			Spacer(Modifier.height(5.dp))
			Text(
				"Crie e gerencie seus campeonatos",
				color = Color.Gray
			
			)
			PostingCard(
				oncontinue = {},
				onAdd = {},
				onRandom = {},
				onClassifier = {},
				competitions = CompetitionsEntity(
					times = 10,
					matches = 10,
					rounds = 2,
					totalRounds = 20,
					name = "",
					isFinished = false,
					totalGoals = 10
				)
			)
			Spacer(modi.height(30.dp))
			Text(
				"Ações rápidas",
				color = Color.White
			)
			Spacer(modi.height(10.dp))
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.spacedBy(5.dp)
			) {
				action.forEach { acts ->
					Column(
						modifier = Modifier
							.width(90.dp)
							.height(90.dp)
							.background(fundocardpill)
							.border(
								1.dp, Color.DarkGray,
								RoundedCornerShape(10.dp)
							),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					) {
						when {
							acts.icon != null -> {
								Icon(
									imageVector = acts.icon,
									contentDescription = "",
									modifier = Modifier.size(30.dp),
									tint = acts.color
								)
								Spacer(
									Modifier.height(
										6.dp
									)
								)
								Text(
									text = acts.text,
									color = Color.White,
									fontSize = 10.sp,
									textAlign = Center,
									modifier = Modifier.height(22.dp)
								)
							}
							
							acts.iconRes !== null -> {
								Icon(
									painter = painterResource(acts.iconRes),
									contentDescription = "",
									tint = acts.color,
									
									)
								Text(
									text = acts.text
								)
							}
						}
					}
				}
			}
			Spacer(modi.height(20.dp))
			
			Text(
				"Campeonatos recentes",
				color = Color.White
			)
			Spacer(modi.height(10.dp))
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.spacedBy(5.dp)
			) {
				recentschampionship.forEach { recents ->
					Column(
						modifier = Modifier
							.width(90.dp)
							.height(150.dp)
							.background(fundocardpill)
							.border(
								1.dp, Color.DarkGray,
								RoundedCornerShape(10.dp)
							)
							.padding(3.dp),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.SpaceAround
					) {
						when {
							recents.icon != null -> {
								
								Image(
									imageVector = recents.icon,
									contentDescription = "",
									colorFilter = ColorFilter.tint
										(Color.White)
								)
								Text(
									text = recents.text,
									color = Color.White
								
								)
							}
							
							recents.iconRes != null -> {
								Icon(
									painter = painterResource(recents.iconRes),
									contentDescription = "",
									tint = recents.color,
									modifier = Modifier.size(40.dp)
								
								)
								Text(
									text = recents.text,
									color = Color.White,
									fontWeight = FontWeight.Bold,
									fontSize = 10.sp, textAlign = Center
								)
								Text(
									text = "$qtd Times\n$rounds/$roundsTotal Rodadas",
									color = GrayBlue,
									fontSize = 10.sp, textAlign = Center
								)
							}
						}
						Box(
							modifier = Modifier
								.fillMaxWidth(0.85f)
								.border(1.dp, borderCardsMini, RoundedCornerShape(7.dp))
								.padding(2.dp)
								.height(20.dp),
							contentAlignment = Alignment.Center
						) {
							Text(
								
								"Abrir", fontSize = 10.sp, color = verdetext,
								textAlign = Center,
								modifier = Modifier.fillMaxWidth(),
							)
							
						}
					}
				}
			}
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.Absolute.SpaceBetween
			) {
				statistics.forEach { statss ->
					val value: String = when (statss) {
						Statistics.ConcluedMatches -> roundsTotal.toString()
						Statistics.TotalGoals -> goals.toString()
						Statistics.TopScorer -> poacher?.name ?: "Nenhum"
						else -> ""
					}
					
					val subtitle = when(statss){
						Statistics.ConcluedMatches -> "Jogos realizados"
						Statistics.TotalGoals -> "Gols marcados"
						Statistics.TopScorer -> "${poacher?.goals ?: 0} gol"
					}
					StattisticsCard(
						statss,
						value = value,
						subtitle = subtitle
					)
				}
			}
		}
		
	}
}

@Preview
@Composable
fun prev() {
	
	val fakeDao = object : DAOTeams {
		override suspend fun inserir(team: TeamsEntity) {}
		override suspend fun atualizar(team: TeamsEntity) {}
		override suspend fun deletar(team: TeamsEntity) {}
		override fun pegarTodos() =
			flowOf(emptyList<TeamsEntity>())
	}
	
	val fakeCompetitionDao = object : DAOCompetitions {
		override suspend fun Inserir(competitions: CompetitionsEntity) {}
		override suspend fun Deletar(competitions: CompetitionsEntity) {}
		override suspend fun Atualizar(competitions: CompetitionsEntity) {}
		override fun pegarTodos() =
			flowOf(emptyList<CompetitionsEntity>())
	}
	val competitionVm: CompetitionViewModel = viewModel(
		factory = CompetitionFactory(fakeCompetitionDao)
	)
	
	val vmfake: TeamViewModel = viewModel(
		factory = SecurityFactoryTeams(fakeDao)
	)
	
	val fake = object : DAOPlayer {
		override fun getTopScorer(): Flow<PlayerEntity> =
			flowOf(
				PlayerEntity(
					id = 1,
					name = "Messi",
					teamId = 1,
					goals = 10
				)
			)
		
	}
	
	val fakeviewprf: PlayerViewModel = viewModel(
		factory = SecurityFactoryPlaye(fake)
	)
	
	HomeScreen(
		teamViewModel = vmfake,
		add = {},
		randomTeams = {},
		viewClassification = {},
		competitionViewModel = competitionVm,
		playerViewModel = fakeviewprf
	)
}