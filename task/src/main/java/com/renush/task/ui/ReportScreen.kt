package com.renush.task.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.renush.task.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(navController: NavController){
    var selectedReason by remember { mutableStateOf("") }
    var otherReason by remember { mutableStateOf(TextFieldValue("")) }
    var isAgreementChecked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Report an Issue",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Routes.Task.routes)
                    },
                        modifier = Modifier
                            .size(width = 27.dp, height = 30.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    ) { innerPadding ->

        // Top Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Help us improve by reporting any issues or inappropriate content.",
                fontSize = 15.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color(0xFF706363)
            )


            val options = listOf(
                "Academic Concerns",
                "Technical Issues",
                "Inappropriate Content",
                "Bullying or Harassment",
                "Other"
            )

            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Why this is inappropriate to you?",
                    fontSize = 15.sp
                )
                options.forEach { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedReason == option,
                            onClick = { selectedReason = option }
                        )
                        Text(
                            text = option,
                            fontSize = 15.sp
                        )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    if (selectedReason == "Other") {
                        BasicTextField(
                            value = otherReason,
                            onValueChange = { otherReason = it },
                            modifier = Modifier
                                .size(width = 342.dp, height = 70.dp)
                                .padding(top = 8.dp)
                                .border(1.dp, Color.Gray, MaterialTheme.shapes.small)
                                .padding(8.dp),
                            singleLine = false,
                            decorationBox = { innerTextField ->
                                if (otherReason.text.isBlank()) {
                                    Text(
                                        text = "Type here..",
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        )
                }

                }
            }

            Spacer(modifier = Modifier.weight(1f))

                Column {
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isAgreementChecked,
                            onCheckedChange = { isAgreementChecked = it }
                        )
                        Text(
                            text = "I agree to share the details of this report for resolution purposes.",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (selectedReason.isNotEmpty() && isAgreementChecked) {
                        Button(
                            onClick = {
                                navController.navigate(Routes.ReportSubmitted.routes)
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
                            Text(
                                "Submit",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp
                            )

                        }
                    }
                }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    val navController = NavController(LocalContext.current)
    ReportScreen(navController)

}