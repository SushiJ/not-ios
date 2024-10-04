package com.example.lemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemon.ui.theme.LemonTheme
import java.time.format.TextStyle
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var state by remember { mutableStateOf(1) }
    val imageResource = when (state) {
        1 -> painterResource(R.drawable.lemon_tree)
        2 -> painterResource(R.drawable.lemon_squeeze)
        3 -> painterResource(R.drawable.lemon_drink)
        else -> painterResource(R.drawable.lemon_restart)
    }
    val textResource = when (state) {
        1 -> stringResource(R.string.tap_lemon_tree)
        2 -> stringResource(R.string.tapping_lemon)
        3 -> stringResource(R.string.drink_it)
        else -> stringResource(R.string.start_again)
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
           when (state) {
               1 -> state = 2
               2 -> if((1..10).random() == 1) state = 3 else state = 2
               3 -> state = 4
               else -> state = 1
           }
        }, colors = ButtonDefaults.buttonColors(containerColor = Color(0x36388c68)), shape = RoundedCornerShape(16.dp)) {
            Image(painter = imageResource, contentDescription = "Lemon tree", modifier = Modifier.height(140.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            textResource,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonAppPreview() {
    LemonTheme {
        LemonApp()
    }
}