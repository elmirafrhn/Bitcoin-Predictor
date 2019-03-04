package com.elmira.farahani.bitcoinpredictor.di

import com.elmira.farahani.bitcoinpredictor.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}