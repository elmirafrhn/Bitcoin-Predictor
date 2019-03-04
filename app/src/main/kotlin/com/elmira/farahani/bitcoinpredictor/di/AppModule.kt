package com.elmira.farahani.bitcoinpredictor.di

import android.content.Context
import com.elmira.farahani.bitcoinpredictor.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(app: App): Context = app.applicationContext
}