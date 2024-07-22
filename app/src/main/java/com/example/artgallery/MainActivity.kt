package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtGalleryTheme {
                ArtGallery()

            }
        }
    }
}

data class Artwork(
    val image: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun ArtGallery() {
    val artworks = listOf(
        Artwork(R.drawable.image1, "Vinland Saga", "Makoto Yukimura", "2019"),
        Artwork(R.drawable.image2, "Vagabond", "Takehiko Inoue", "1999"),
        Artwork(R.drawable.image3, "Berserk", "Kentaro Miura", "1989")
    )
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = artworks[currentIndex].image),
                contentDescription = "Artwork",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "${artworks[currentIndex].title}\n${artworks[currentIndex].artist} (${artworks[currentIndex].year})",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                }
            }) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                if (currentIndex < artworks.size - 1) {
                    currentIndex++
                }
            }) {
                Text("Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewArtGallery() {
        ArtGallery()

}