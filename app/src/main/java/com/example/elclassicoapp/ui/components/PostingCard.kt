package com.example.elclassicoapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elclassicoapp.R
import com.example.elclassicoapp.data.CompetitionsEntity
import com.example.elclassicoapp.ui.colors.buttoncolor
import com.example.elclassicoapp.ui.colors.fundoPai
import com.example.elclassicoapp.ui.colors.verdetext

@Composable
fun PostingCard(
	onAdd: () -> Unit,
	onRandom: () -> Unit,
	oncontinue: () -> Unit,
	onClassifier: () -> Unit, competitions: CompetitionsEntity
) {
	
	val tipo = "times"
	
	Card(
		colors = CardDefaults.cardColors(
			fundoPai
		),
		modifier = Modifier
			.fillMaxWidth()
			.height(220.dp)
			.background(fundoPai)
			.padding(5.dp),
	) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(1.dp), contentAlignment = Alignment.CenterEnd
		) {
			Image(
				painter = painterResource(R.drawable.imgpostting),
				contentDescription = null,
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.Inside,
			)
			Box(modifier = Modifier.padding(5.dp)) {
				Column() {
					Text("CAMPEONATO ATUAL", fontSize = 8.sp, color = verdetext)
					Spacer(Modifier.height(2.dp).padding(5.dp))
					Text(
						"Meu Campeonato",
						fontSize = 16.sp,
						fontWeight = FontWeight.Bold,
						color = Color.White
					)
					Spacer(Modifier.height(10.dp))
					Row(
						modifier = Modifier
							.fillMaxWidth(0.5f), verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Default.Group,
							tint = Color.White,
							contentDescription = "",
							modifier = Modifier.size(20.dp)
						)
						Spacer(Modifier.width(9.dp))
						
						Text(
							text = "${competitions.times} times", fontSize = 11.sp, color = Color.White
						)
					}
					Spacer(Modifier.height(2.dp))
					
					Row(
						modifier = Modifier.fillMaxWidth(0.5f), verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Default.CalendarMonth,
							tint = Color.White,
							contentDescription = "",
							modifier = Modifier.size(20.dp)
						)
						Spacer(Modifier.width(9.dp))
						
						Text(
							text = "${competitions.rounds} ª Rodada de ${competitions.totalRounds} ",
							fontSize = 11.sp,
							color =
								Color.White
						)
					}
					Spacer(Modifier.height(2.dp))
					
					Row(
						modifier = Modifier.fillMaxWidth(0.5f), verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Default.SportsSoccer,
							tint = Color.White,
							contentDescription = "",
							modifier = Modifier.size(20.dp)
						)
						Spacer(Modifier.width(9.dp))
						
						Text(
							text = "${competitions.matches} Partidas jogadas",
							fontSize = 11.sp,
							color = Color.White
						)
					}
					Spacer(Modifier.height(7.dp))
					
					Button(
						modifier = Modifier.fillMaxWidth(0.45f),
						onClick = {},
						shape = RoundedCornerShape(10.dp),
						colors = ButtonDefaults.buttonColors(
							buttoncolor,
						),
					) {
						Row(
							modifier = Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceBetween,
							verticalAlignment = Alignment.CenterVertically
						) {
							Text(
								"Continuar Campeonato",
								fontSize = 8.sp,
								modifier = Modifier
									.fillMaxWidth(0.8f),
								textAlign = TextAlign.Center
							)
							Spacer(Modifier.width(8.dp))
							Icon(
								imageVector = Icons.Default.ArrowForwardIos,
								modifier = Modifier.size(15.dp),
								contentDescription = ""
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
fun prevs() {
	PostingCard(
		onAdd = {},
		onClassifier = {},
		competitions = CompetitionsEntity(
			times = 15,
			matches = 30,
			rounds = 15,
			totalRounds = 35,
			name = "",
			isFinished = false,
			totalGoals = 0,
		),
		oncontinue = {},
		onRandom = {}
	)
}