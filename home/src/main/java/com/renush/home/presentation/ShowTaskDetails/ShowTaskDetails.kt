package com.renush.home.presentation.ShowTaskDetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun ShowTaskDetails(navController: NavHostController) {



    Scaffold(
        topBar = {
            MyTopAppBar(navController)
        }
    ) {innerPadding->

        MainScreen(Modifier.padding(innerPadding))

    }


}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavHostController) {

    CenterAlignedTopAppBar(navigationIcon = {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.clickable {
navController.popBackStack()
        })
    },
        title = {
            Text("Internship Details", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        })
}



@Composable
fun MainScreen(modifier: Modifier) {

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text("No Data")

    }

}




@Preview
@Composable
fun Preview(){

    ShowTaskDetails(rememberNavController())

}
