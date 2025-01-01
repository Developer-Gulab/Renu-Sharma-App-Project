package com.renush.home.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.renush.home.Models.TaskDataModel

@Composable
fun TaskData() {

    val data = getTaskData()

    LazyColumn {
        items(data) {
            ShowData(it)
        }
    }
}



@Composable
fun ShowData(taskDataModel: TaskDataModel) {
    Card (modifier = Modifier.fillMaxWidth().padding(14.dp).height(80.dp), colors = CardDefaults.cardColors(
        Color.LightGray)){


        Row {

            Box(
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(20))
                    .background(Color.Blue.copy(alpha = 0.7f)), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(39.dp)
                )
            }

            Column( modifier = Modifier.padding(start = 14.dp, top = 8.dp)) {
                Text(taskDataModel.taskName, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))
                Text(taskDataModel.taskSubmissionDate, fontSize = 13.sp)

            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp, end = 6.dp), horizontalArrangement = Arrangement.End) { Text(taskDataModel.taskStatus, color = Color.Red, fontWeight = FontWeight.Bold)  }

        }

    }
}


fun getTaskData():List<TaskDataModel>{
    return listOf(TaskDataModel("Loading Page","submission date 15 Nov,2024","Pending"),
        TaskDataModel("Dashboard Design","submission date 17 Nov,2024","Pending"),
        TaskDataModel("Login/Sign Up Page","submission date 19 Nov,2024","Pending"),
        TaskDataModel("Mobile App Ui Design","submission date 22 Nov,2024","Pending")
    )
}