package com.bitcoin.predictor.bitcoinpredictor.di

import android.content.Context
import com.bitcoin.predictor.bitcoinpredictor.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(app: App): Context = app.applicationContext
}