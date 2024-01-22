package xyz.marko.w1d3_md3

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.marko.w1d3_md3.ui.theme.W1d3_MD3Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { W1d3_MD3Theme { MainScaffold() } }
  }
}

@Composable
fun MainScaffold() {
  Scaffold(topBar = { MainTopBar() }, floatingActionButton = { MainFloatingActionButton() }) {
      paddingValues ->
    MainContent(paddingValues = paddingValues)
  }
}

@Composable
fun MainContent(paddingValues: PaddingValues) {
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(paddingValues).padding(12.dp).fillMaxSize()) {
        MainCard()
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
        IconButton(onClick = { /* TODO */}) { Icon(Icons.Filled.ArrowBack, null) }
      },
      actions = { IconButton(onClick = { /* TODO */}) { Icon(Icons.Filled.AccountCircle, null) } })
}

@Composable
fun MainCard() {
  ElevatedCard(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
      Image(
          painter = painterResource(R.drawable.forest),
          contentScale = ContentScale.FillWidth,
          contentDescription = "Forest with sun rays cast through the canopy.",
          modifier = Modifier.fillMaxWidth())
      Text(
          text =
              "Mieleni minun tekevi, aivoni ajattelevi lähteäni laulamahan, saa'ani sanelemahan, sukuvirttä suoltamahan, lajivirttä laulamahan. Sanat suussani sulavat, puhe'et putoelevat, kielelleni kerkiävät, hampahilleni hajoovat.")
    }
  }
}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun MainScaffoldPreview() {
  W1d3_MD3Theme { MainScaffold() }
}
