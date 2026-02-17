package com.habitarc.app.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.habitarc.app.ui.H_PADDING
import com.habitarc.app.MainActivity
import com.habitarc.app.ui.VStack
import com.habitarc.app.ui.ZStack
import com.habitarc.app.ui.c
import com.habitarc.app.ui.SquircleShape

private val dialogShape = SquircleShape(24.dp)

@Composable
fun NavigationDialog(
    layer: NavigationLayer,
    innerPadding: PaddingValues = PaddingValues(H_PADDING),
    content: @Composable ColumnScope.(layer: NavigationLayer) -> Unit,
) {
    val mainActivity = LocalContext.current as MainActivity
    ZStack(
        modifier = Modifier
            .padding(top = mainActivity.statusBarHeightDp)
            .padding(vertical = 8.dp)
            .systemBarsPadding()
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        VStack(
            modifier = Modifier
                .padding(horizontal = H_PADDING * 2)
                .clip(dialogShape)
                .background(c.fg)
                .pointerInput(Unit) {}
                .padding(innerPadding)
        ) {
            content(layer)
        }
    }
}
