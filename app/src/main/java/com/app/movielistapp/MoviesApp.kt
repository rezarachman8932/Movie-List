package com.app.movielistapp

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.app.movielistapp.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class MoviesApp: MultiDexApplication(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)

        startKoin {
            androidContext(this@MoviesApp)
            modules(appComponent)
        }
    }
}