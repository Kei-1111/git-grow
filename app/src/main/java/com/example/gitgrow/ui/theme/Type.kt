@file:Suppress("MagicNumber")

package com.example.gitgrow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gitgrow.R

val NotoSansJp = FontFamily(
    Font(R.font.noto_sans_jp_regular, FontWeight.Normal),
    Font(R.font.noto_sans_jp_medium, FontWeight.Medium),
    Font(R.font.noto_sans_jp_semi_bold, FontWeight.SemiBold),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = NotoSansJp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),

    labelMedium = TextStyle(
        fontFamily = NotoSansJp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp,
    ),
)
