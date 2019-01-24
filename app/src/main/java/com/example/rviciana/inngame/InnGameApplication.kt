package com.example.rviciana.inngame

import android.app.Application
import com.example.rviciana.inngame.di.ApplicationComponent
import com.example.rviciana.inngame.di.ApplicationModule
import com.example.rviciana.inngame.di.DaggerApplicationComponent

class InnGameApplication: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initializeInjector()
    }

    private fun initializeInjector() {
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule())
                .build()

        component.inject(this)
    }

}