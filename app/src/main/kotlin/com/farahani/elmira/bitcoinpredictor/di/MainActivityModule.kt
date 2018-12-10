package com.farahani.elmira.bitcoinpredictor.di

import com.farahani.elmira.bitcoinpredictor.*
import com.farahani.elmira.bitcoinpredictor.network.ApiService
import com.farahani.elmira.bitcoinpredictor.network.IApiService
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}