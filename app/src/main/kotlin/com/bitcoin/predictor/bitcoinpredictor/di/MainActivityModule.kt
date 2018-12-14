package com.bitcoin.predictor.bitcoinpredictor.di

import com.bitcoin.predictor.bitcoinpredictor.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}