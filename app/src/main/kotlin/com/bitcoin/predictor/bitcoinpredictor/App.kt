package com.bitcoin.predictor.bitcoinpredictor

import com.bitcoin.predictor.bitcoinpredictor.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)
}