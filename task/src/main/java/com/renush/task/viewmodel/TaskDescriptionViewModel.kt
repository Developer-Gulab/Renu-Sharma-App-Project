package com.renush.task.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renush.task.model.Task

class TaskDescriptionViewModel: ViewModel() {
    val task = MutableLiveData<Task>()

    init {
        task.value = Task(
            title = "Landing Page",
            submissionDate = "15 Nov, 2024",
            details = """
                Designing a UI for a Coffee Shop Landing Page
                
                A coffee shop’s landing page should reflect its ambiance, offerings, and values while enticing visitors to take action. Here's a breakdown of designing the perfect UI:
                
                Key Components to Include:
                ◆ Hero Section:
                  - Showcase a mouthwatering image of your signature coffee or cozy shop interior.
                  - Include a welcoming headline (e.g., "Brewed with Love, Served with Care") and a clear CTA like "Order Now" or "Visit Us."
                
                ◆ About Us:
                  - Share the story behind your coffee shop, highlighting its unique features (e.g., locally sourced beans, sustainable practices).
                  - Use warm tones and friendly language to create an emotional connection.
                
                ◆ Menu Section:
                  - Feature a snapshot of your offerings with images of popular drinks and snacks.
                  - Include a "See Full Menu" button that directs users to a detailed menu page.
                
                ◆ Special Offers or Events:
                  - Highlight promotions, loyalty programs, or upcoming events like live music nights or barista workshops.
                  - Use banners or badges to draw attention.
                
                ◆ Testimonials:
                  - Add quotes or reviews from happy customers.
                  - Use photos or ratings to make them more visually appealing.
                
                ◆ Location and Hours:
                  - Include an easy-to-read map and your address, phone number, and opening hours.
                  - Add a "Get Directions" button for seamless navigation.
            """.trimIndent()
        )
    }
}