package com.android.jitpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android")

        }
    }
}

@Composable
fun Greeting(name: String) {
    val counter = remember {
        mutableStateOf(0)
    }
    val innerPadding = PaddingValues(top = 20.dp, start = 20.dp, end = 20.dp)
    Text(
        text = "Clicks: ${counter.value}",
        fontSize = 17.sp,
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .background(Color(0xFFFFCA28), RoundedCornerShape(16.dp))
            .height(60.dp)
//            .width(150.dp)
            .clickable(onClick = { counter.value += 1 })
            .padding(innerPadding)
    )
}

