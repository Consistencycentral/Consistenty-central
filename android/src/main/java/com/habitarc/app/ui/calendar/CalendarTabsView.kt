package com.habitarc.app.ui.calendar

import androidx.activity.compose.LocalActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.habitarc.app.ui.HStack
import com.habitarc.app.ui.H_PADDING
import com.habitarc.app.MainActivity
import com.habitarc.app.ui.VStack
import com.habitarc.app.ui.c
import com.habitarc.app.goldenRatioUp
import com.habitarc.app.ui.halfDpCeil
import com.habitarc.app.ui.onePx
import com.habitarc.app.ui.squircleShape
import com.habitarc.app.ui.calendar.list.CalendarListView
import com.habitarc.app.ui.tasks.tab.TasksTabView__PADDING_END

private val menuTopPadding: Dp = 8.dp
private val menuBottomPadding: Dp =
    menuTopPadding.goldenRatioUp().goldenRatioUp()

@Composable
fun CalendarTabsView() {

    val isCalendarOrList = remember {
        mutableStateOf(true)
    }

    val mainActivity = LocalActivity.current as MainActivity

    VStack(
        modifier = Modifier
            .padding(top = mainActivity.statusBarHeightDp)
            .fillMaxSize(),
    ) {

        if (isCalendarOrList.value) {
            CalendarView(
                modifier = Modifier
                    .weight(1f),
            )
        } else {
            CalendarListView(
                modifier = Modifier
                    .weight(1f),
            )
        }

        Divider(
            modifier = Modifier
                .padding(start = H_PADDING, end = TasksTabView__PADDING_END),
        )

        HStack(
            modifier = Modifier
                .padding(top = menuTopPadding, bottom = menuBottomPadding),
        ) {

            ModeButton(
                text = "Calendar",
                modifier = Modifier
                    .padding(start = H_PADDING - halfDpCeil),
                isActive = isCalendarOrList.value,
                onClick = {
                    isCalendarOrList.value = true
                },
            )

            ModeButton(
                text = "List",
                modifier = Modifier
                    .padding(start = 8.dp),
                isActive = !isCalendarOrList.value,
                onClick = {
                    isCalendarOrList.value = false
                },
            )
        }
    }
}

@Composable
private fun ModeButton(
    text: String,
    modifier: Modifier,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    val bgAnimate =
        animateColorAsState(if (isActive) c.blue else c.transparent).value
    Text(
        text = text,
        modifier = modifier
            .clip(shape = squircleShape)
            .clickable {
                onClick()
            }
            .background(bgAnimate)
            .padding(horizontal = 7.dp)
            .padding(top = 2.dp + onePx, bottom = 2.dp),
        color = if (isActive) c.white else c.text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    )
}
