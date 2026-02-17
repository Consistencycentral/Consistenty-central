package com.habitarc.app.ui.form.button

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.habitarc.app.ui.HStack
import com.habitarc.app.ui.H_PADDING
import com.habitarc.app.ui.SpacerW1
import com.habitarc.app.ui.c
import com.habitarc.app.ui.form.form__itemMinHeight
import com.habitarc.app.ui.form.FormItemView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FormButtonView(
    title: String,
    titleColor: Color?,
    isFirst: Boolean,
    isLast: Boolean,
    modifier: Modifier,
    rightView: @Composable () -> Unit,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)?,
) {

    FormItemView(
        isFirst = isFirst,
        isLast = isLast,
        modifier = modifier,
        content = {

            HStack(
                modifier = Modifier
                    .combinedClickable(
                        onClick = onClick,
                        onLongClick = onLongClick,
                    )
                    .sizeIn(minHeight = form__itemMinHeight),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    text = title,
                    modifier = Modifier
                        .padding(start = H_PADDING, end = 10.dp),
                    color = titleColor ?: c.text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Box(Modifier.weight(1f))

                rightView()
            }
        },
    )
}
