package com.renush.task.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.renush.task.navigation.Routes
import com.renush.task.viewmodel.TaskViewModel

@ExperimentalMaterial3Api
@Composable
fun TaskDetailsScreen(viewModel: TaskViewModel = viewModel(), navController: NavController) {

    val task by viewModel.task.observeAsState()
    var showDialog by remember { mutableStateOf(false) }
    var isMenuExpanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Task Details",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold)
                },

                navigationIcon = {
                    IconButton(onClick = {
                        // Handle back navigation
                    },
                        modifier = Modifier
                            .size(width = 27.dp, height = 30.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                modifier = Modifier
                    .padding(16.dp)

            )
        },

        content = { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Card(
                    modifier = Modifier
                        .size(width = 339.dp, height = 239.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    task?.let { currentTask ->
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(currentTask.title,
                                        fontSize = 15.sp,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(text = "Submission Date: ${currentTask.submissionDate}",
                                        fontSize = 10.sp,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Normal,
                                    )
                                }

                                Box{
                                    IconButton(onClick = {
                                        isMenuExpanded = true
                                    }) {
                                        Icon(Icons.Default.MoreVert, contentDescription = "More Options")
                                    }

                                    DropdownMenu(
                                        expanded = isMenuExpanded,
                                        onDismissRequest = { isMenuExpanded = false },
                                        modifier = Modifier
                                            .size(width = 70.dp, height = 50.dp)
                                    ) {
                                        DropdownMenuItem(
                                            text = { Text("Report")},
                                            onClick = {
                                                isMenuExpanded = false
                                                navController.navigate(Routes.Report.routes)
                                            }
                                        )
                                    }
                                }

                            }

                            Text(
                                text = "Task Details",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.SemiBold
                            )


                            Text(
                                text = currentTask.details,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Normal
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(onClick = {
                                    showDialog = true
                                },
                                    modifier = Modifier
                                        .size(width = 74.dp, height = 22.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF5F93FB) // Directly use the hex code
                                    )
                                ) {
                                    Text(text = "Know more",
                                        fontWeight = FontWeight.Normal,
                                        style = MaterialTheme.typography.labelSmall,
                                    )
                                }
                                if (showDialog){
                                    TaskDescriptionDialog(
                                        onDismiss = {showDialog = false}
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))

                Button(onClick = {
                    navController.navigate(Routes.Upload.routes)
                },
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(width = 339.dp, height = 40.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5F93FB) // Directly using the hex code
                    )
                ) {
                    Text("Submit Work",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp)
                }
            }
        }

    )

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TaskDetailsScreenPreview() {
    val navController = rememberNavController()
    val viewModel = TaskViewModel()
    TaskDetailsScreen(viewModel, navController)
}