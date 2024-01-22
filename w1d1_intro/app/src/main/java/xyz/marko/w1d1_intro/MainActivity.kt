package xyz.marko.w1d1_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.marko.w1d1_intro.ui.theme.W1d1_introTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { W1d1_introTheme { MainScaffold() } }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold() {
  Scaffold(
      topBar = {
        TopAppBar(
            colors =
                topAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.Black,
                ),
            title = { Text(text = "placeholder") })
      }) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(padding).padding(5.dp).fillMaxSize()) {
              Column(
                  verticalArrangement = Arrangement.SpaceBetween,
                  horizontalAlignment = Alignment.CenterHorizontally,
                  modifier =
                      Modifier.background(Color.Cyan)
                          .fillMaxWidth()
                          .fillMaxHeight(0.5f)
                          .padding(16.dp)) {
                    Text(text = "Hello Darkness!")
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.background(Color.Blue).size(200.dp)) {
                          Text("2")
                        }
                 }
              Button(onClick = { /*TODO*/}) { Text(text = "klikkaa mua") }
            }
      }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview() {
  W1d1_introTheme { MainScaffold() }
}
