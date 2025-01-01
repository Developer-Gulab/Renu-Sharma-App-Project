package com.renush.task.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.renush.task.R

@Composable
fun TaskCard(
    taskName: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .size(width = 351.dp, height = 60.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD9D9D9)
        )
    ) {
        Row (
            modifier = Modifier
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_pdf),
                contentDescription = "PDF Icon",
                modifier = Modifier
                    .size(width = 67.dp, height = 50.dp)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = taskName,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreviewSelected() {
    TaskCard(
        taskName = "Task1",
        onClick = { /* Handle click */ }
    )
}



