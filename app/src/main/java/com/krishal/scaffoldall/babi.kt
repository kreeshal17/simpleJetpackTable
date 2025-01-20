@file:Suppress("UNREACHABLE_CODE")

package com.krishal.scaffoldall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


data class navData(
      val title:String,
       val selected:ImageVector,
    val unselected:ImageVector,
    val  badge:Int?=0)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun babi()
{

    val items= listOf(

        navData("home",Icons.Filled.Share,Icons.Outlined.Share),
                navData("refresh",Icons.Filled.Share,Icons.Outlined.Refresh),
    navData("email",Icons.Filled.Share,Icons.Outlined.Email,33),
    navData("exit",Icons.Filled.Share,Icons.Outlined.ExitToApp)





    )
    val  scope= rememberCoroutineScope()
    var textf by remember {
        mutableStateOf("")
    }
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    var show by remember {
        mutableStateOf(false)
    }
 var scrollbehaviour= TopAppBarDefaults.enterAlwaysScrollBehavior()
    val drawerState= rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent ={
            ModalDrawerSheet {
                items.forEachIndexed { index, item ->

                    NavigationDrawerItem(
                        label = {
                            Text(text=item.title)
                        },
                        selected = index==selectedItemIndex,
                        onClick = {
                           selectedItemIndex=index
                        },

                        icon = {
                            Icon(imageVector = if(index==selectedItemIndex)
                            {
                                item.selected
                            }
                            else {
                                item.unselected
                            }, contentDescription = item.title)

                        },
                        badge = {
                            item.badge?.let{
                                Text(text=item.badge.toString())
                            }
                        }

                    )


                }

            }


        }

    )













    {



    Scaffold(modifier = Modifier.fillMaxSize().nestedScroll(scrollbehaviour.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text="Note Pad")

                },

                navigationIcon ={
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
                        }


                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "this is menu")
                    }
                },
                actions ={
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Edit, contentDescription = "this is menu")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Favorite, contentDescription = "this is menu")
                    }

                },

                scrollBehavior = scrollbehaviour
            )
        }
        , bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.LocationOn, contentDescription = "this is menu")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.AccountBox, contentDescription = "this is menu")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                },
                floatingActionButton = {
                    FloatingActionButton(onClick ={ } ) {
                        IconButton(onClick = {show=!show}) {
                            Icon(Icons.Default.Add, contentDescription = "this is menu")
                        }
                    }
                }




            )
        }








    ) {


            paddingValues ->


        if (show) {
            Box(modifier = Modifier.fillMaxWidth().padding(paddingValues)) {
                OutlinedTextField(
                    value = textf,
                    onValueChange = { textf = it },
                    label = { Text(text = "add value") })

            }
        } else {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(100) { item ->
                    Text(text = "krishal $item", modifier = Modifier.padding(16.dp))
                }


            }

        }


    }


    }




}