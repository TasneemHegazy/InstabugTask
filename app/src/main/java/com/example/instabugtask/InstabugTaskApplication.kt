package com.example.instabugtask

import android.app.Application
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent

class InstabugTaskApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupInstabugSDK()
    }

    private fun setupInstabugSDK() {
        Instabug.Builder(this, "8f5337843fe8a934aab4788585dcb488")
            .setInvocationEvents(InstabugInvocationEvent.SHAKE, InstabugInvocationEvent.FLOATING_BUTTON)
            .build()
    }
}
