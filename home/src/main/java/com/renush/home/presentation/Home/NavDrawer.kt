package com.renush.home.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.renush.home.Models.TaskDataModel
import com.renush.home.R
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
                        Icon(painter = painterResource(R.drawable.notify), contentDescription = null, modifier = Modifier.size(30.dp).padding(end = 8.dp))
                    }
                }
            )
        }) { innerPadding ->

            val i=innerPadding
            Home(Modifier.padding(innerPadding))
        }

    }

}




@Composable
fun Home(modifier: Modifier) {
Column(modifier = modifier.fillMaxSize()) {

    Box(modifier = Modifier.fillMaxWidth().height(160.dp).padding(8.dp).clip(RoundedCornerShape(20)).paint(painter = painterResource(R.drawable.coursebg), contentScale = ContentScale.FillBounds)){

        Column(modifier = Modifier.padding(20.dp)) {
            Text("Ui/UX Design Internship", fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text("3 Month", fontSize = 19.sp, color = Color.White)
            Spacer(Modifier.height(12.dp))
            Text("Progress 100%", color = Color.White)
            Spacer(Modifier.height(6.dp))
            LinearProgressIndicator(trackColor = Color.White, color = Color.White)

        }

        Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, end = 4.dp), horizontalArrangement = Arrangement.End) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
        }

    }


    Text("Tasks", fontSize = 18.sp, fontWeight = FontWeight.Bold ,modifier=Modifier.padding(10.dp))


    TaskData()


}

}




@Composable
fun DrawerContent(){

    Column (modifier = Modifier.fillMaxHeight() .width(250.dp).background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally){


        Column (modifier = Modifier.fillMaxWidth().clip(
            RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 30.dp)
        ) .height(200.dp).background(Color.Blue),){
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = Color.White,  modifier = Modifier.size(100.dp))
            Text("Jhone Doe",  color = Color.White , fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 12.dp))
            Text("jhondoe@gmai.com",  color = Color.White , fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 12.dp))

        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {

            Row (modifier = Modifier.padding(6.dp)){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                Text("  My Profile", modifier = Modifier.padding(3.dp))
            }

            Row (modifier = Modifier.padding(6.dp)){
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                Text("  Dashboard", modifier = Modifier.padding(3.dp))
            }


            Row (modifier = Modifier.padding(6.dp)){
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
                Text("  Cirtificate", modifier = Modifier.padding(3.dp))
            }

            Row (modifier = Modifier.padding(6.dp)){
                Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                Text("  Settings", modifier = Modifier.padding(3.dp))
            }
            Row (modifier = Modifier.padding(6.dp)){
                Icon(imageVector = Icons.Default.Warning, contentDescription = null)
                Text("  Help", modifier = Modifier.padding(3.dp))
            }

            Column (modifier = Modifier.fillMaxSize().padding(bottom = 20.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally){

                Row (modifier = Modifier.padding(6.dp)){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.Red)
                    Text("  Logout" , color = Color.Red, modifier = Modifier.padding(3.dp))
                }

            }

        }
    }

}



@Composable
fun TaskData(){



    val data= getTaskData()

    LazyColumn  {
items(data){
 ShowData(it)
}
    }




}

@Composable
fun ShowData(taskDataModel: TaskDataModel) {
    Card (modifier = Modifier.fillMaxWidth().padding(14.dp).height(80.dp), colors = CardDefaults.cardColors(Color.LightGray)){


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