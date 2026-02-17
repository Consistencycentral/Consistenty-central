package com.habitarc.app.ui.form.padding

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.habitarc.app.ui.VStack
import com.habitarc.app.ui.ZStack

@Composable
fun FormPaddingBottom(
    withNavigation: Boolean,
) {
    VStack {
        FormPaddingSectionSection()
        if (withNavigation) {
            ZStack(Modifier.navigationBarsPadding())
        }
    }
}
