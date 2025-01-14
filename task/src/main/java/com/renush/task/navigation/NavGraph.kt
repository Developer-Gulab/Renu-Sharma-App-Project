package com.renush.task.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.renush.task.ui.PDFUploadScreen
import com.renush.task.ui.ReportScreen
import com.renush.task.ui.ReportSubmittedScreen
import com.renush.task.ui.TaskDetailsScreen
import com.renush.task.ui.TaskSubmittedScreen
import com.renush.task.viewmodel.TaskViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(modifier: Modifier, navController: NavController){
    val navController = rememberNavController()
    val viewModel = TaskViewModel()
    NavHost(navController = navController, startDestination = Routes.Task.routes){
        composable(Routes.Task.routes){
            TaskDetailsScreen(viewModel,navController)
        }
        composable(Routes.Upload.routes) {
            PDFUploadScreen(navController)
        }
        composable(Routes.Submitted.routes) {
            TaskSubmittedScreen(navController)
        }
        composable(Routes.Report.routes) {
            ReportScreen(navController)
        }
        composable(Routes.ReportSubmitted.routes) {
            ReportSubmittedScreen(navController)
        }
    }
}