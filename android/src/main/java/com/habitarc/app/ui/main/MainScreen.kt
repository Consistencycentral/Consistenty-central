package com.habitarc.app.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.habitarc.app.ui.VStack
import com.habitarc.app.ui.ZStack
import com.habitarc.app.ui.activity.ActivityScreen
import com.habitarc.app.ui.home.HomeScreen
import com.habitarc.app.ui.navigation.NavigationScreen
import com.habitarc.app.ui.settings.SettingsScreen
import com.habitarc.app.ui.tasks.tab.TasksTabView

@Composable
fun MainScreen() {

    val tab = remember {
        mutableStateOf(MainTabEnum.home)
    }

    VStack {

        ZStack(
            modifier = Modifier
                .weight(1f),
        ) {
            when (tab.value) {
                MainTabEnum.home -> {
                    NavigationScreen {
                        HomeScreen()
                    }
                }
                MainTabEnum.activities -> {
                    NavigationScreen {
                        ActivityScreen(
                            onClose = {
                                tab.value = MainTabEnum.home
                            },
                        )
                    }
                }
                MainTabEnum.tasks -> {
                    NavigationScreen {
                        TasksTabView(
                            onClose = {
                                tab.value = MainTabEnum.home
                            },
                        )
                    }
                }
                MainTabEnum.settings -> {
                    NavigationScreen {
                        SettingsScreen(
                            onClose = {
                                tab.value = MainTabEnum.home
                            },
                        )
                    }
                }
            }
        }

        MainTabsView(
            tab = tab.value,
            onTabChanged = { newTab ->
                tab.value = newTab
            },
        )
    }
}
