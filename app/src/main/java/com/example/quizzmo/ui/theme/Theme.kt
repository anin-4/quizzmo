package com.example.quizzmo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorPalette = lightColors(
    primary = blue200,
    primaryVariant = blue100,
    secondary = yellow200,
    secondaryVariant = yellow100,
    onPrimary = black,
    onSecondary = black,
    surface = Color.White,
    onSurface = Color.Black
    )

private val DarkColorPalette = darkColors(
    surface = black200,
    onSurface = Color.White,
    primary = blue200,
    primaryVariant = blue100,
    onPrimary = Color.White
)

@Composable
fun QuizzmoTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit,
) {

    val systemUiController = rememberSystemUiController()


    val colors = if (!useDarkTheme) {
        systemUiController.setSystemBarsColor(
            color = backgroundDeeperBlue
        )
        LightColorPalette
    } else {
        systemUiController.setSystemBarsColor(
            color = black200
        )
        DarkColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}