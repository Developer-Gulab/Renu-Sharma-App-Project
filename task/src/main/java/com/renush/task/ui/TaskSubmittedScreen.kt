package com.renush.task.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.renush.task.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskSubmittedScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},

                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    },
                        modifier = Modifier
                            .size(width = 24.dp, height = 24.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                modifier = Modifier
                    .padding(16.dp)

            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(modifier = Modifier.height(121.dp))

                Card(
                    modifier = Modifier
                        .size(width = 351.dp, height = 258.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFEFEFEF)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(29.dp)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.group),
                            contentDescription = "Submitted",
                            modifier = Modifier
                                .size(width = 100.dp, height = 100.dp))

                        Spacer(modifier = Modifier.height(8.dp))


                        Text(text = "Task Submitted Successfully",
                            color = Color.Black,
                            modifier = Modifier
                                .size(width = 252.dp, height = 94.dp)
                                .align(Alignment.CenterHorizontally),
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 32.sp
                        )
                    }

                }

                Spacer(modifier = Modifier.weight(1f))

                Button(onClick = {

                },
                    modifier = Modifier
                        .padding(bottom = 104.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(width = 370.dp, height = 64.dp),
                    shape = RoundedCornerShape(21.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5F93FB) // Directly using the hex code
                    )) {
                    Text(text = "See the Submissions",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp)
                }
            }

        }
    )
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TaskSubmittedScreenPreview() {
    val navController = rememberNavController()
    TaskSubmittedScreen(navController)
}