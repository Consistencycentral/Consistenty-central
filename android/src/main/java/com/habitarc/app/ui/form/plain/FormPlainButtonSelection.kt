package com.habitarc.app.ui.form.plain

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.habitarc.app.ui.HStack
import com.habitarc.app.ui.H_PADDING
import com.habitarc.app.R
import com.habitarc.app.ui.ZStack
import com.habitarc.app.ui.c
import com.habitarc.app.ui.roundedShape
import com.habitarc.app.ui.Divider
import com.habitarc.app.ui.form.form__itemMinHeight

@Composable
fun FormPlainButtonSelection(
    title: String,
    isSelected: Boolean,
    isFirst: Boolean,
    modifier: Modifier,
    onClick: () -> Unit,
) {

    ZStack(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
    ) {

        HStack(
            modifier = Modifier
                .defaultMinSize(minHeight = form__itemMinHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            @DrawableRes
            val icon: Int = if (isSelected)
                R.drawable.sf_checkmark_circle_fill_medium_regular
            else
                R.drawable.sf_circle_medium_regular

            val tintColor: Color =
                if (isSelected) c.blue else c.gray3

            ZStack(
                modifier = Modifier
                    .padding(start = H_PADDING)
            ) {
                if (isSelected) {
                    ZStack(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(iconSize - 2.dp)
                            .clip(roundedShape)
                            .background(color = c.white),
                    )
                }
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Select",
                    tint = tintColor,
                    modifier = Modifier
                        .size(iconSize),
                )
            }

            Text(
                text = title,
                modifier = Modifier
                    .padding(start = H_PADDING)
                    .padding(vertical = 4.dp),
                color = c.text,
            )
        }

        if (!isFirst) {
            Divider(
                modifier = Modifier
                    .padding(start = dividerPadding)
                    .align(Alignment.TopEnd)
            )
        }
    }
}

///

private val iconSize: Dp = 22.dp
private val dividerPadding: Dp = (H_PADDING + iconSize + H_PADDING)
