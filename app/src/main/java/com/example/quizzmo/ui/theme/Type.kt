package com.example.quizzmo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quizzmo.R

val gothamFontFamily = FontFamily(
    Font(R.font.gotham_bold,FontWeight.Bold),
    Font(R.font.gotham_light,FontWeight.Light),
    Font(R.font.gotham_medium,FontWeight.Medium),
    Font(R.font.gotham_book,FontWeight.Normal)
)


val Typography = Typography(

    h1 = TextStyle(
        fontFamily = gothamFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = gothamFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3= TextStyle(
        fontFamily = gothamFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = gothamFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)