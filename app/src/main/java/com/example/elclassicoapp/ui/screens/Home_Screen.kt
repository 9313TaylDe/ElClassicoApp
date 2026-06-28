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
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.elclassicoapp.data.Actions
import com.example.elclassicoapp.data.Competitions
import com.example.elclassicoapp.data.DAOCompetitions
import com.example.elclassicoapp.data.DAOTeams
import com.example.elclassicoapp.data.TeamsEntity
import com.example.elclassicoapp.repository.CompetitionFactory
import com.example.elclassicoapp.repository.CompetitionViewModel
import com.example.elclassicoapp.repository.SecurityFactoryTeams
import com.example.elclassicoapp.repository.TeamViewModel
import com.example.elclassicoapp.ui.colors.borderCardsMini
import com.example.elclassicoapp.ui.colors.fundoPai
import com.example.elclassicoapp.ui.colors.fundocardpill
import com.example.elclassicoapp.ui.colors.verdetext
import com.example.elclassicoapp.ui.components.PostingCard
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(
	teamViewModel: TeamViewModel,
	competitionViewModel: CompetitionViewModel,
	add: () -> Unit,
	viewClassification: () -> Unit,
	randomTeams: () -> Unit,
) {
	
	val action = listOf(
		Actions.new_camp,
		Actions.teams,
		Actions.matches,
		Actions.ranking,
	)
	val recentschampionship = listOf(
		Actions.Brasileriao,
		Actions.ChampionsLeague,
		Actions.CopaDoMundo,
		Actions.CopaNacional,
	)
	val modi = Modifier
	val qtd by teamViewModel.quantidadeTimes.collectAsStateWithLifecycle()
	val competition by competitionViewModel.quantidaderodadas.collectAsStateWithLifecycle()
	val championship: Competitions
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
				oncontinue = {}, onAdd = {}, onRandom = {}, onClassifier = {}, competitions = Competitions(
					times = 10,
					matches = 10,
					rounds = 2,
					totalRounds = 20,
					name = "",
					isFinished = false
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
									tint = acts.color
								)
							}
							
							acts.iconRes !== null -> {
								Icon(
									painter = painterResource(acts.iconRes),
									contentDescription = "",
									tint = acts.color,
									
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
									tint = Color.White,
									modifier = Modifier.size(40.dp)
								
								)
								Text(
									text = qtd.toString(),
									color = Color.White,
									fontSize = 10.sp, textAlign = Center
								)
								Text(
									text = competition.toString(),
									color = Color.White,
									fontSize = 10.sp, textAlign = Center
								)
								Text(
									text = recents.text,
									color = Color.White,
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
			kotlinx.coroutines.flow.flowOf(emptyList<TeamsEntity>())
	}
	
	val fakeCompetitionDao = object : DAOCompetitions {
		override suspend fun Inserir(competitions: Competitions) {}
		override suspend fun Deletar(competitions: Competitions) {}
		override suspend fun Atualizar(competitions: Competitions) {}
		override fun pegarTodos() =
			flowOf(emptyList<Competitions>())
	}
	val competitionVm: CompetitionViewModel = viewModel(
		factory = CompetitionFactory(fakeCompetitionDao)
	)
	
	val vmfake: TeamViewModel = viewModel(
		factory = SecurityFactoryTeams(fakeDao)
	)
	
	HomeScreen(
		teamViewModel = vmfake,
		add = {},
		randomTeams = {},
		viewClassification = {},
		competitionViewModel = competitionVm
	)
}