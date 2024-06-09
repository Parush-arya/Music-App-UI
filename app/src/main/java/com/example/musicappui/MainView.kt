package com.example.musicappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(modifier: Modifier, navController: NavHostController, show: MutableState<Boolean>) {
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()
    var drawerSelected = "Account"
    var bottomSelected = "none"

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Music App", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Account") },
                    selected = drawerSelected == "Account",
                    onClick = {
                        drawerSelected = "Account"
                        navController.navigate("Account")
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.AccountCircle, "") }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Subscription") },
                    selected = drawerSelected == "Subscription",
                    onClick = {
                        drawerSelected = "Subscription"
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
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .wrapContentSize(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { navController.navigate("Home") },
                            Modifier.background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(0.dp)
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black
                            )
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(Icons.Default.Home, "", Modifier.size(32.dp))
                                Text(text = "Home", color = Color.Black)
                            }
                        }

                        Button(
                            onClick = { navController.navigate("Browse") },
                            Modifier.background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(0.dp)
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black
                            )
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(Icons.Default.Search, "", Modifier.size(32.dp))
                                Text(text = "Browse", color = Color.Black)
                            }
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            Modifier.background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(0.dp)
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black
                            )
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(Icons.Default.List, "", Modifier.size(32.dp))
                                Text(text = "Library", color = Color.Black)
                            }
                        }
                    }
                }
            },
            topBar = {
                TopAppBar(title = { Text(if (drawerSelected == "None") bottomSelected else drawerSelected) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            },
                            content = {
                                Icon(Icons.Default.AccountCircle, "")
                            }
                        )
                    }
                )
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(navController, startDestination = "Account") {
                    composable("Account") {
                        Account()
                    }

                    composable("Subscription") {
                        Subscription()
                    }

                    composable("Home") {
                        Home()
                    }

                    composable("Browse") {
                        Browse()
                    }

                    composable("Library") {

                    }
                }
            }
        }
    }
}

