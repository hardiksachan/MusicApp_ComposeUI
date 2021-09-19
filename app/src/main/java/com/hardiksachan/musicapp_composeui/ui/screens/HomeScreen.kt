package com.hardiksachan.musicapp_composeui.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hardiksachan.musicapp_composeui.R

@Composable
fun HomeScreen(handleThemeSwitch: () -> Unit) {
    Scaffold(
        topBar = {
            GreetingSection(
                Modifier.padding(
                    horizontal = 32.dp,
                    vertical = 16.dp
                )
            ) { handleThemeSwitch() }
        }
    ) {

    }
}


@Composable
fun GreetingSection(
    modifier: Modifier = Modifier,
    handleThemeSwitch: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "hey there.",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.W500,
            letterSpacing = (-1.5).sp,
        )
        Icon(
            painter = painterResource(
                id = if (MaterialTheme.colors.isLight)
                    R.drawable.ic_sun
                else
                    R.drawable.ic_moon
            ),
            contentDescription = "theme icon",
            modifier = Modifier
                .size(28.dp)
                .padding(bottom = 8.dp)
                .clickable {
                    handleThemeSwitch()
                },
        )

    }
}