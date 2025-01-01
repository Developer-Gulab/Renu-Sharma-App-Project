package com.renush.task.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renush.task.model.Task

class TaskViewModel: ViewModel() {
    val task = MutableLiveData<Task>()

    init {
        task.value = Task(
            title = "Landing Page",
            submissionDate = "15 Nov, 2024",
            details = """
                Designing a UI for a Coffee Shop Landing Page
                
                A coffee shop’s landing page should reflect its ambiance, offerings, and values while enticing visitors to take action...
            """.trimIndent()
        )
    }
}