package com.renush.task.navigation

sealed class Routes(val routes: String){
    data object Task: Routes("task")
    data object Upload: Routes("upload")
    data object Submitted: Routes("submitted")
}