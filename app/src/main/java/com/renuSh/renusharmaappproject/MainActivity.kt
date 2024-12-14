package com.renuSh.renusharmaappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.renuSh.renusharmaappproject.ui.theme.RenuSharmaAppProjectTheme
import com.renush.onboarding.Screen.OnboardingScreen
import com.renush.onboarding.Utils.OnboardingUtils
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RenuSharmaAppProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        if (onboardingUtils.isOnboardingCompleted()) {
                            ShowHomeScreen()
                        } else {
                            ShowOnboardingScreen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ShowHomeScreen() {

        Column {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
        }


    }

    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }


    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        RenuSharmaAppProjectTheme {
//            Greeting("Android")
        }
    }
}