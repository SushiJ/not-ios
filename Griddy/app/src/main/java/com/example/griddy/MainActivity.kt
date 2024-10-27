package com.example.griddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.griddy.data.DataSource
import com.example.griddy.data.Topic
import com.example.griddy.ui.theme.GriddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GriddyTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GriddyApp()
                }
            }
        }
    }
}

@Composable
fun GriddyApp() {
    GriddyGrid( modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp))
}

@Composable
fun GriddyCard(topic: Topic) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(topic.image),
                    contentDescription = stringResource(topic.topic),
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(topic.topic),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp,
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = topic.value.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GriddyGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            GriddyCard(topic)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GriddyTheme {
        GriddyApp()
    }
}