package com.example.instabugtask

import android.app.Application
import com.instabug.library.Instabug // "This is the main Instabug SDK class that initializes the SDK and sets up different SDK features."
import com.instabug.library.invocation.InstabugInvocationEvent // "This is the class that represents the different invocation events that invoke the SDK's UI."

//"This is the application class that is used to initialize the Instabug SDK."
class InstabugTaskApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // "This method initializes the Instabug SDK."
        setupInstabugSDK()
    }

    private fun setupInstabugSDK() {
        Instabug.Builder(this, "APP_TOKEN")
            .setInvocationEvents(InstabugInvocationEvent.SHAKE, InstabugInvocationEvent.FLOATING_BUTTON) // "This method sets the invocation events that invoke the SDK's UI."
            .build()

    }
}
