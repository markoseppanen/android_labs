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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.marko.w1d1_intro.ui.theme.Pink40
import xyz.marko.w1d1_intro.ui.theme.Purple40
import xyz.marko.w1d1_intro.ui.theme.Purple80
import xyz.marko.w1d1_intro.ui.theme.PurpleGrey80
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
    var darkness by remember { mutableStateOf(false) }
    var name by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                topAppBarColors(
                    containerColor = Purple40,
                    titleContentColor = PurpleGrey80,
                ),
                title = { Text(stringResource(R.string.app_name)) },
            )
        },
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(padding)
                .padding(5.dp)
                .fillMaxSize(),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                Modifier
                    .background(Purple40)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(16.dp),
            ) {
                if (name.isEmpty()) {
                    if (darkness) {
                        Text(
                            text = stringResource(R.string.goodbye_darkness),
                            color = PurpleGrey80,
                            fontSize = 24.sp
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.hello_world),
                            color = PurpleGrey80,
                            fontSize = 24.sp
                        )
                    }
                } else {
                    Text(
                        text = stringResource(R.string.hello_name, name),
                        color = PurpleGrey80,
                        fontSize = 24.sp
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(Purple80)
                        .size(200.dp),
                ) {
                    Text("2", color = Pink40)
                }
            }
            TextField(value = name, onValueChange = { name = it })
            Button(
                onClick = { darkness = !darkness },
                colors =
                ButtonDefaults.buttonColors(
                    containerColor = Purple40,
                    contentColor = PurpleGrey80,
                ),
            ) {
                Text(text = stringResource(R.string.click_me))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview() {
    W1d1_introTheme { MainScaffold() }
}
