package com.example.android.composetest

import androidx.compose.Composable
import androidx.ui.core.CurrentTextStyleProvider
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle

val customGreen = Color(0xFF1EB980.toInt())
val customSurface = Color(0xFF26282F.toInt())

private val themeColors = MaterialColors(
    primary = customGreen,
    surface = customSurface,
    onSurface = Color.Black
)

@Composable
fun CustomTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        val textStyle = TextStyle(color = Color.Red)
        CurrentTextStyleProvider(value = textStyle) {
            children()
        }
    }
}