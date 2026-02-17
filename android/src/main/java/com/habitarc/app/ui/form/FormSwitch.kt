package com.habitarc.app.ui.form

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.habitarc.app.ui.c
import com.habitarc.app.ui.halfDpFloor
import com.habitarc.app.ui.form.button.FormButtonView

@Composable
fun FormSwitch(
    title: String,
    isEnabled: Boolean,
    isFirst: Boolean,
    isLast: Boolean,
    modifier: Modifier = Modifier,
    onChange: (Boolean) -> Unit,
) {
    FormButtonView(
        title = title,
        titleColor = c.text,
        isFirst = isFirst,
        isLast = isLast,
        modifier = modifier,
        rightView = {
            Switch(
                checked = isEnabled,
                onCheckedChange = { newValue ->
                    onChange(newValue)
                },
                modifier = Modifier
                    .padding(end = 9.dp, bottom = halfDpFloor),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = c.blue,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.Gray,
                ),
            )
        },
        onClick = {
            onChange(!isEnabled)
        },
        onLongClick = null,
    )
}
