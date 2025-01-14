package com.renush.task.navigation

sealed class Routes(val routes: String){
    data object Task: Routes("task")
    data object Upload: Routes("upload")
    data object Submitted: Routes("submitted")
    data object Report: Routes("report")
    data object ReportSubmitted: Routes("reportSubmitted")
}