package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    App (
                        name = "Android",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun App(name: String, modifier: Modifier = Modifier) {
    Column {
        NameAndTitle(modifier = Modifier)
    }
}

@Composable
fun NameAndTitle(modifier: Modifier) {
    val image = painterResource(R.drawable.svg)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(Dp(10f))) {
        Image(painter = image, contentDescription = null, Modifier.background(color = MaterialTheme.colorScheme.primary))
        Column {
            Text(
                "Sushant Sharma"
            )
            Text(
                "Software engineer"
            )
        }
    }
}

@Composable
fun Contact() {
    Column {
        Text(
            ""
        )
        Text(
            ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        App("Android")
    }
}