package com.hardiksachan.musicapp_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hardiksachan.musicapp_composeui.ui.screens.HomeScreen
import com.hardiksachan.musicapp_composeui.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var darkThemeState by remember {
                mutableStateOf(false)
            }

            AppTheme(darkTheme = darkThemeState) {
                HomeScreen { darkThemeState = !darkThemeState }
            }
        }
    }
}