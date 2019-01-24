package com.example.rviciana.inngame.di

import com.example.rviciana.inngame.InnGameApplication
import com.example.rviciana.inngame.presentation.IndustryActivity
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: InnGameApplication)

    fun inject(activity: IndustryActivity)

}