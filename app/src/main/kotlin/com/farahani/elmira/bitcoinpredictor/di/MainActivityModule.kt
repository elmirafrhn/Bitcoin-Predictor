package com.farahani.elmira.bitcoinpredictor.di

import com.farahani.elmira.bitcoinpredictor.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}