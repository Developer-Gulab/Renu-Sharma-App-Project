package com.renush.home.presentation.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.renush.home.R
import com.renush.home.Routes.Routes








@Composable
fun Home(modifier: Modifier, navController: NavHostController) {

    Column(modifier = modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxWidth().height(160.dp).padding(8.dp).clip(RoundedCornerShape(20)).paint(painter = painterResource(
            R.drawable.coursebg), contentScale = ContentScale.FillBounds)){

                Column(modifier = Modifier.padding(20.dp)) {
                Text("Ui/UX Design Internship", fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text("3 Month", fontSize = 19.sp, color = Color.White)
                Spacer(Modifier.height(12.dp))
                Text("Progress 100%", color = Color.White)
                Spacer(Modifier.height(6.dp))
                LinearProgressIndicator(trackColor = Color.White, color = Color.White)

            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, end = 4.dp), horizontalArrangement = Arrangement.End) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(Routes.TaskDetails.Routes)
                })
            }

        }


        Text("Tasks", fontSize = 18.sp, fontWeight = FontWeight.Bold ,modifier= Modifier.padding(10.dp))


        TaskData()


    }

}
