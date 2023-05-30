package com.example.instabugtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instabugtask.ui.theme.InstabugTaskTheme
import com.instabug.chat.Replies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstabugTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ViewChatsButton()
                }
            }
        }
    }
}
@Composable
fun ViewChatsButton() {
    Button(onClick = {
        Replies.show()
    }) {
        Text(text = "View Chats")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstabugTaskTheme {
        ViewChatsButton()
    }
}