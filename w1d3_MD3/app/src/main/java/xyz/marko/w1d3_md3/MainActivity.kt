package xyz.marko.w1d3_md3

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.marko.w1d3_md3.ui.theme.W1d3_MD3Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { W1d3_MD3Theme {  MainScaffold() } }
  }
}

data class Message(val author: String, val body: String)

object SampleData {
  // Sample conversation data
  val conversationSample =
      listOf(
          Message("Lexi", "Test...Test...Test..."),
          Message(
              "Lexi",
              """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)"""
                  .trim()),
          Message(
              "Lexi",
              """I think Kotlin is my favorite programming language.
            |It's so much fun!"""
                  .trim()),
          Message("Lexi", "Searching for alternatives to XML layouts..."),
          Message(
              "Lexi",
              """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)"""
                  .trim()),
          Message("Lexi", "It's available from API 21+ :)"),
          Message(
              "Lexi",
              "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"),
          Message("Lexi", "Android Studio next version's name is Arctic Fox"),
          Message("Lexi", "Android Studio Arctic Fox tooling for Compose is top notch ^_^"),
          Message(
              "Lexi", "I didn't know you can now run the emulator directly from Android Studio"),
          Message(
              "Lexi",
              "Compose Previews are great to check quickly how a composable layout looks like"),
          Message("Lexi", "Previews are also interactive after enabling the experimental setting"),
          Message("Lexi", "Have you tried writing build.gradle with KTS?"),
      )
}

@Composable
fun MainScaffold() {
  Scaffold(topBar = { MainTopBar() }, floatingActionButton = { MainFloatingActionButton() }) {
      paddingValues ->
    MainContent(paddingValues = paddingValues)
  }
}

val testMessage = Message("Marko", "Moi vaan")

@Composable
fun MainContent(paddingValues: PaddingValues) {
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(paddingValues).padding(12.dp).fillMaxSize()) {
        Conversation(messages = SampleData.conversationSample)
      }
}

@Composable
fun MainFloatingActionButton() {
  FloatingActionButton(onClick = {}) { Text("+") }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
  CenterAlignedTopAppBar(
      colors =
          TopAppBarDefaults.topAppBarColors(
              containerColor = MaterialTheme.colorScheme.primaryContainer,
              titleContentColor = MaterialTheme.colorScheme.primary,
          ),
      title = { Text("Top Bar") },
      navigationIcon = {
        IconButton(onClick = { /* TODO */}) {
          Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
        }
      },
      actions = {
        IconButton(onClick = { /* TODO */}) {
          Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Account")
        }
      })
}

@Composable
fun Conversation(messages: List<Message>) {
  LazyColumn{ items(messages) { message -> MessageCard(message) } }
}

@Composable
fun MessageCard(msg: Message) {
  ElevatedCard(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp)) {
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
      Image(
          painter = painterResource(R.drawable.forest),
          contentScale = ContentScale.FillWidth,
          contentDescription = "Forest with sun rays cast through the canopy.",
          modifier = Modifier.fillMaxWidth())
      Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth().padding(4.dp)) {
            Text(text = msg.author, fontWeight = FontWeight.ExtraBold)
            Text(text = msg.body, textAlign = TextAlign.End)
          }
      Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth().padding(4.dp)) {
            Button(onClick = { /*TODO*/}) {
              Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = "Thumbs up.")
            }
            Button(onClick = { /*TODO*/}) {
              Icon(imageVector = Icons.Filled.Star, contentDescription = "Star.")
            }
          }
    }
  }
}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun MainScaffoldPreview() {
  W1d3_MD3Theme { MainScaffold() }
}
