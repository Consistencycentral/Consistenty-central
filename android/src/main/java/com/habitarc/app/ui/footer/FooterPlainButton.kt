package com.habitarc.app.ui.footer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.habitarc.app.ui.H_PADDING_HALF
import com.habitarc.app.ui.squircleShape

@Composable
fun FooterPlainButton(
    text: String,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit,
) {
    Text(
        text = text,
        modifier = Modifier
            .clip(squircleShape)
            .clickable {
                onClick()
            }
            .padding(horizontal = H_PADDING_HALF, vertical = 4.dp),
        color = color,
        fontWeight = fontWeight,
    )
}
