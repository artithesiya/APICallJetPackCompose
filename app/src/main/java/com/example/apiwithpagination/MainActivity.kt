package com.example.apiwithpagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.apiwithpagination.ui.theme.APIwithPaginationTheme
import com.example.apiwithpagination.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APIwithPaginationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GetAPIData(innerPadding, viewModel)
                }
            }
        }
    }
}

@Composable
private fun GetAPIData(innerPadding: PaddingValues, viewModel: MainViewModel) {
    val data by viewModel.artists
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(data.size) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
//                Image(
//                    painter = rememberAsyncImagePainter(data[it].image),
//                    contentDescription = null,
//                    modifier = Modifier.size(128.dp)
//                )
                Image(
//                    model = data[it].image,
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Translated description of what the image contains",
                    modifier = Modifier.size(75.dp).padding(end = 10.dp)
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Text(
                        text = data[it].name,
                        fontSize = 30.sp
                    )
                    Text(
                        text = data[it].bio,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }
    DisposableEffect(Unit) {
        viewModel.getArtists(0)
        onDispose {}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    APIwithPaginationTheme {
//        Greeting("Android")
//        LazyColumn(
//            modifier = Modifier
//                .padding(10.dp)
//                .background(color = Color.Black)
//        ) {
//            Row {
//                Text(text = "testing")
//            }
//
//        }
    }
}