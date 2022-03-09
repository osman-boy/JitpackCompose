package com.android.jitpackcomposeexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Person(val name: String, val lastname: String, val profession: String)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val persons = mutableListOf<Person>()
        for (i in 0..1000){
            persons.add(Person("John","Wick","Killer"))
        }
        setContent {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                , horizontalAlignment = Alignment.CenterHorizontally) {
                itemsIndexed(persons) { _, item ->
                    ListItem(name = item.name, lastname = item.lastname, profession = item.profession)
                }

            }
        }
    }
}


@Composable
fun ListItem(name: String, lastname: String, profession: String) {
    val counter = remember {
        mutableStateOf(0)
    }
    val color: MutableState<Color> = remember {
        mutableStateOf(Color.Black)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                color.value = when (++counter.value) {
                    in 0..5 -> Color.Black
                    in 6..11 -> Color.Red
                    in 12..18 -> Color.Green
                    in 19..25 -> Color.Yellow
                    else -> Color.Black
                }

            },
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "User is image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "$name $lastname", fontSize = 16.sp)
                    Text(text = profession)
                    Text(
                        text = "killed person count: ${counter.value}",
                        color = color.value
                    )
                }
            }
        }
    }
}