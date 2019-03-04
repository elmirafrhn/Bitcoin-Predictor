package com.elmira.bitcoin.bitcoinpredictor.di

import com.elmira.bitcoin.bitcoinpredictor.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}