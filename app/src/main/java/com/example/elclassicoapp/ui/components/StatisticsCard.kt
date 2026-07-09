package com.example.elclassicoapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.elclassicoapp.data.Statistics

@Composable

fun StattisticsCard(
	statistics: Statistics,
	value: String = "",
	subtitle: String = ""
) {
	Column() {

		Icon(
			imageVector = statistics.icon, "", tint = statistics.color
		)
		Text(
			value,
			color = Color.White
		)
		
		if (subtitle.isNotEmpty()) {
			Text(subtitle, 	color = Color.White)
		}
	}
}