package com.renush.onboarding.Utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonUi(
    text: String = "Next",
    backgroundColor: Color = Color(0xFF5F93FB),
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    fontSize: Int = 14,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, contentColor = textColor
        ), shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text, fontSize = fontSize.sp
        )

    }


}


@Preview
@Composable
fun NextButton() {

    ButtonUi (text = "Next") {

    }




}