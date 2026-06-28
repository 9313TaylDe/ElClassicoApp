package com.example.elclassicoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.elclassicoapp.data.Actions
import com.example.elclassicoapp.ui.colors.fundocardpill

@Composable
fun ActionsPills(
	actions: Actions
) {
	
	Column(
		modifier = Modifier.background(fundocardpill)
	) {
		Text(
			actions.text
		)
		when {
			actions.icon != null -> {
				Icon(
					imageVector = actions.icon,
					contentDescription = "",
					tint = actions.color
				)
			}
			
			actions.iconRes != null -> {
				Icon(
					painter = painterResource(actions.iconRes),
					contentDescription = "",
					tint = actions.color
				)
			}
			
		}
	}
}