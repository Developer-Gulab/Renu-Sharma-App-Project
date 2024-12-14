package com.renush.onboarding.Model

import androidx.annotation.DrawableRes
import com.renush.onboarding.R

sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        image = com.renuSh.renusharmaappproject.R.drawable.ob_img1,
        title = "What We Do?",
        description = "We Offer Internships To Build Skills, Boost Careers and Gain Real-World Experience"
    )

    data object SecondPage : OnboardingModel(
        image = com.renuSh.renusharmaappproject.R.drawable.ob_img2,
        title = "What is Renu Sharma?",
        description = "Renu Sharma NGO Empowers Individuals Through Education And Skill-Building,Opening Doors To Real-World Growth And Meaningful Opportunities"
    )

    data object ThirdPages : OnboardingModel(
        image = com.renuSh.renusharmaappproject.R.drawable.ob_img3,
        title = "Why Join Us?",
        description = "Gain Practical Experience,Grow Your Skills And Kickstart Your Career With Meaningful Opportunities"
    )


}