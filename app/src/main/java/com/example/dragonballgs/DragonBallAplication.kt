package com.example.dragonballgs

import android.app.Application
import databaseModule
import networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import repositoryModule
import useCaseModule
import viewModelModule

class DragonBallAplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@DragonBallAplication)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}
