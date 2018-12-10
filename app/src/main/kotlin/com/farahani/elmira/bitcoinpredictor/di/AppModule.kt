package com.farahani.elmira.bitcoinpredictor.di

import android.content.Context
import com.farahani.elmira.bitcoinpredictor.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(app: App): Context = app.applicationContext
}