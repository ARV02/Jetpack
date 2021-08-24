package com.example.jetpack.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.R
import com.example.jetpack.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun FacebookButton(
    text: String = "Sign Up with Facebook",
    loadingText: String = "Creating an account ...",
    icon: Painter = painterResource(id = R.drawable.ic_facebook),
    onClicked: () -> Unit
) {
    var clicked by remember { mutableStateOf(false)}
    Surface(
        onClick = {clicked= ! clicked},
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color(0xFF1976D2)),
        color = Color(0xFF1976D2),
        contentColor = Color(0xFFFFFFFF)
    ) {
        Row (
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
                ) {
            Icon(painter = icon,
                contentDescription = "GoogleButton",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text( text = if (clicked) loadingText else text)
            if (clicked){
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
                onClicked()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun FacebookButtonPreview(){
    FacebookButton(
        text = "Sign Up with Facebook",
        loadingText = "Creating an account...",
        onClicked = {}
    )
}