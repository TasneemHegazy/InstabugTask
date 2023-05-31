package com.example.instabugtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instabugtask.ui.theme.InstabugTaskTheme
import com.instabug.chat.Replies
import com.instabug.crash.CrashReporting
import com.instabug.crash.models.IBGNonFatalException


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // "Called when the activity is starting."
        super.onCreate(savedInstanceState) // "Perform initialization of all fragments and loaders."
        setContent {
            InstabugTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ViewChatsButton()
                        ReportCrashButton()
                    }
                }
            }
        }
    }
}
@Composable
fun ViewChatsButton() {
    Button(onClick = {
        if (Replies.hasChats()) { // "This method checks if there are any chats to show."
            Replies.show() // "This method shows the chats list."
        } else {
            println("You have no pre-existing chats.")
        }
    }) {
        Text(text = "View Chats")
    }
}

@Composable
fun ReportCrashButton() {
    Button(onClick = {
        IBGNonFatalException.Builder(NullPointerException("Test Exception"))
            .setUserAttributes(mapOf("height" to "tall"))
            .setFingerprint("My Custom Fingerprint")
            .setLevel(IBGNonFatalException.Level.CRITICAL)
            .build().let { exception -> CrashReporting.report(exception) }
    }) {
        Text(text = "Report Crash")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() { // "This method is used to preview the UI."
    InstabugTaskTheme {
        ViewChatsButton()
        ReportCrashButton()
    }
}