package com.elmira.farahani.bitcoinpredictor.di

import com.elmira.farahani.bitcoinpredictor.intercator.IMainInteractor
import com.elmira.farahani.bitcoinpredictor.intercator.MainInteractor
import com.elmira.farahani.bitcoinpredictor.presenter.IMainPresenter
import com.elmira.farahani.bitcoinpredictor.presenter.MainPresenter
import com.elmira.farahani.bitcoinpredictor.utils.BitcoinPriceClassifier
import com.elmira.farahani.bitcoinpredictor.view.IMainView
import com.elmira.farahani.bitcoinpredictor.view.MainFragment
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

        @Provides
        @JvmStatic
        fun provideBitcoinPriceClassifier(): BitcoinPriceClassifier {
            return BitcoinPriceClassifier()
        }
    }
}