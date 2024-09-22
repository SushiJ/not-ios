package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskCompletedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskCompletedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskImage(
                        title = "All tasks completed",
                        comment = "Nice work!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Task(title: String, comment: String) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = comment,
            fontSize = 16.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun TaskImage(title: String, comment: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = image,
                contentDescription = null
            )
            Task(title, comment)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskCompletedTheme {
    }
}