package com.example.android.composetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(child: @Composable() () -> Unit) {
    CustomTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

@Composable
fun MyScreenContent(appState: AppState = AppState()) {
    Column(modifier = ExpandedHeight, crossAxisAlignment = CrossAxisAlignment.Center) {
        Column(modifier = Flexible(1f), crossAxisAlignment = CrossAxisAlignment.Center) {
            Greeting(name = "Android")
            Divider(color = Color.Black)
            Greeting(name = "there")
        }
        Counter(state = appState.counterState)
        HeightSpacer(height = 16.dp)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Spacing(24.dp),
        style = +themeTextStyle { h1 }
    )
}

class AppState(val counterState: CounterState = CounterState())

@Model
class CounterState(var count: Int = 0)

@Composable
fun Counter(state: CounterState) {
    Button(
        text = "I've been clicked ${state.count} times",
        onClick = { state.count++ }
    )
}

@Preview("MyApp")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

@Preview("Greeting")
@Composable
fun GreetingPreview() {
    CustomTheme {
        Greeting(name = "world")
    }
}