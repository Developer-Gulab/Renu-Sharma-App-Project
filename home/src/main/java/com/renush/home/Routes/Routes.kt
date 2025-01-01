package com.renush.home.Routes


sealed class Routes (val Routes:String){

    object Home:Routes("Home")
    object TaskDetails:Routes("TaskDetails")
    object NotificationPage:Routes("NotificationPage")

}