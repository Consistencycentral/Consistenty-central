package com.habitarc.app

import androidx.compose.ui.graphics.Color
import me.timeto.shared.ColorRgba

fun ColorRgba.toColor() =
    Color(r, g, b, a)
