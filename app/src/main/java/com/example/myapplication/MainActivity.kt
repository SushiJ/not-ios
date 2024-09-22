package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArticleImage(
                        title = stringResource(R.string.article_title),
                        content = stringResource(R.string.article_content_1),
                        content2 = stringResource(R.string.article_content_2)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String, content: String, content2: String) {
   Column {
       Text (
          text = title,
           fontSize = 24.sp,
           modifier = Modifier.padding(16.dp)
       )
       Text (
           text = content,
           modifier = Modifier.padding(16.dp),
           textAlign = TextAlign.Justify
       )
       Text (
           text = content2,
           modifier = Modifier.padding(16.dp),
           textAlign = TextAlign.Justify
       )
   }
}

@Composable
fun ArticleImage(title: String, content: String, content2: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Article(title, content, content2)
    }
}
@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticleTheme {
        ArticleImage("Title", "Content", "Content2")
    }
}