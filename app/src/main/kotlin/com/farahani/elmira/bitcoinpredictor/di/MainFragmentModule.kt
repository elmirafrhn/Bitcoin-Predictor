package com.farahani.elmira.bitcoinpredictor.di

import com.farahani.elmira.bitcoinpredictor.*
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMainPresenter(presenter: MainPresenter<IMainView, IMainInteractor>): IMainPresenter<IMainView,IMainInteractor>{
            return presenter
        }

        @Provides
        @JvmStatic
        fun provideMainInteractor(interactor: MainInteractor): IMainInteractor {
            return interactor
        }
    }
}