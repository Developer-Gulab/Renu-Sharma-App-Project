package com.renush.onboarding.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renush.onboarding.Model.OnboardingModel
import com.renush.onboarding.Utils.ButtonUi
import com.renush.onboarding.Utils.IndicatorUI
import kotlinx.coroutines.launch

// Adjustment to button Size and Alignment Ui will be completed

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {

    val pages = listOf(
        OnboardingModel.FirstPage, OnboardingModel.SecondPage, OnboardingModel.ThirdPages
    )

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("Next")
                1 -> listOf( "Next")
                2 -> listOf( "Start")
                else -> listOf("")
            }
        }
    }

    val scope = rememberCoroutineScope()

    Scaffold(bottomBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp),
        ) {


            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
                    }
                }
                Row(modifier = Modifier.padding(vertical = 8.dp)) {
                    ButtonUi(
                        text =  buttonState.value[0],
                        backgroundColor = Color(0xFF5F93FB),
                        textColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        scope.launch {
                            if (pagerState.currentPage < pages.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            } else {
                                onFinished()
                            }
                        }
                    }
                }

            }

            //


        }
    }, content = {
        Column(Modifier.padding(it)) {

            OutlinedButton(
                onClick = {
                    onFinished()
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(0.dp, 10.dp, 5.dp, 0.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Skip")
            }

            HorizontalPager(state = pagerState) { index ->
                OnboardingGraphUI(onboardingModel = pages[index])
            }
        }
    })


}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen {

    }
}