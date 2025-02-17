package com.example.tp4

import NetworkModule
import android.app.Application
import com.example.tp4.model.post.view.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, NetworkModule, appModule)
        }

    }
}
