package com.farahani.elmira.bitcoinpredictor.di

import com.farahani.elmira.bitcoinpredictor.intercator.IMainInteractor
import com.farahani.elmira.bitcoinpredictor.presenter.IMainPresenter
import com.farahani.elmira.bitcoinpredictor.intercator.MainInteractor
import com.farahani.elmira.bitcoinpredictor.presenter.MainPresenter
import com.farahani.elmira.bitcoinpredictor.view.IMainView
import com.farahani.elmira.bitcoinpredictor.view.MainFragment
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
        fun provideMainPresenter(presenter: MainPresenter<IMainView, IMainInteractor>): IMainPresenter<IMainView, IMainInteractor> {
            return presenter
        }

        @Provides
        @JvmStatic
        fun provideMainInteractor(interactor: MainInteractor): IMainInteractor {
            return interactor
        }
    }
}