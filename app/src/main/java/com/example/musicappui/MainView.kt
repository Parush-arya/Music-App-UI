package com.example.musicappui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@Composable
fun MainView(modifier: Modifier, navController: NavHostController, show: MutableState<Boolean>) {
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Music App", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Account") },
                    selected = false,
                    onClick = {
                        navController.navigate("Account")
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.AccountCircle, "") }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Subscription") },
                    selected = false,
                    onClick = {
                        navController.navigate("Subscription")
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.CheckCircle, "") }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Add Account") },
                    selected = false,
                    onClick = {
                        show.value = true
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.AddCircle, "") }
                )
            }
        }
    ) {
        NavHost(navController, startDestination = "Account") {
            composable("Account") {
                Account(drawerState = drawerState, scope = scope)
            }

            composable("Subscription") {
                Subscription(drawerState = drawerState, scope = scope)
            }
        }
    }
}

