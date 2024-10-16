package com.example.tp4


import android.app.Application
import com.example.tp4.model.post.retrofit.AppComponent
import com.example.tp4.model.post.retrofit.DaggerAppComponent


class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}
