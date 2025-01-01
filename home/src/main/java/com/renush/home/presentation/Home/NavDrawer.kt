package com.renush.home.presentation.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renush.home.R
import com.renush.home.Routes.Navigation
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NavDrawer() {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(drawerContent = {
        DrawerContent()
    }, drawerState = drawerState) {

        Scaffold(topBar = {
            TopAppBar(title = {},
                navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp) .clickable {
                        if (drawerState.isOpen) {
                            scope.launch {
                                drawerState.close()
                            }
                        } else {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    })
            },
                actions = {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                        Icon(painter = painterResource(R.drawable.notify), contentDescription = null, modifier = Modifier.size(30.dp).padding(end = 8.dp).clickable {

                        })
                    }
                }
            )
        }) { innerPadding ->
            Navigation(Modifier.padding(innerPadding))
        }
    }
}





















