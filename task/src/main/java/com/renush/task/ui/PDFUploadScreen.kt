package com.renush.task.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.renush.task.R
import com.renush.task.navigation.Routes
import com.renush.task.utils.TaskCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PDFUploadScreen(navController: NavController) {
    var selectedTask by remember { mutableStateOf<String?>(null) }
    var pdfUri by remember { mutableStateOf<Uri?>(null) }
    LocalContext.current
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == Activity.RESULT_OK) {
            pdfUri = result.data?.data
        }

    }
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
                .padding(innerPadding)
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (pdfUri == null) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                                        addCategory(Intent.CATEGORY_OPENABLE)
                                        type = "application/pdf"
                                    }
                                    filePickerLauncher.launch(intent)
                                },
                                modifier = Modifier
                                    .size(70.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = Color.Transparent
                                ),
                                enabled = pdfUri == null
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.upload),
                                    contentDescription = "Upload PDF"
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            if (pdfUri == null) {
                                Text(
                                    text = "Upload PDF",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.W400
                                )
                            }
                        }
                    } else {
                        TaskCard(
                            taskName = "Task",
                            onClick = { selectedTask = "Task" }
                        )
                    }
                }

                Button(onClick = {
                    if (pdfUri != null) {
                        navController.navigate(Routes.Submitted.routes)
                    }
                },
                    modifier = Modifier
                        .padding(bottom = 116.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(width = 370.dp, height = 52.dp),
                    shape = RoundedCornerShape(21.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5F93FB) // Directly using the hex code
                    ),
                    enabled = pdfUri != null
                ) {
                    Text("Submit Work",
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
fun PDFUploadScreenPreview() {
    val navController = rememberNavController()
    PDFUploadScreen(navController)
}