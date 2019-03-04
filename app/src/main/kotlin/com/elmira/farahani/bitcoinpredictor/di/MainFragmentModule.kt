package com.elmira.bitcoin.bitcoinpredictor.di

import com.elmira.bitcoin.bitcoinpredictor.intercator.IMainInteractor
import com.elmira.bitcoin.bitcoinpredictor.intercator.MainInteractor
import com.elmira.bitcoin.bitcoinpredictor.presenter.IMainPresenter
import com.elmira.bitcoin.bitcoinpredictor.presenter.MainPresenter
import com.elmira.bitcoin.bitcoinpredictor.utils.BitcoinPriceClassifier
import com.elmira.bitcoin.bitcoinpredictor.view.IMainView
import com.elmira.bitcoin.bitcoinpredictor.view.MainFragment
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