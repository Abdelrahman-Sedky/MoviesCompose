package com.example.movies.ui.theme

import androidx.compose.ui.graphics.Color

val Primary = Color(0xFFFF5524)
val Stroke = Color(0xFFE5E5E5)
val Text = Color(0xDE000000)
val Background = Color(0xFFFFFFFF)

data class CustomColorsPalette(
    val primary: Color = Color.Unspecified,
    val stroke: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val textColor: Color = Color.Unspecified,
)