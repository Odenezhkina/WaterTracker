package com.study.watertracker.ui.theme

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

enum class TextFontStyle(val fontSize: TextUnit,val fontWeight: FontWeight) {
    H1(fontSize = 52.sp, fontWeight = FontWeight.ExtraBold),
    H3(fontSize = 20.sp, fontWeight = FontWeight.Medium),
}
