package com.bitcoin.predictor.bitcoinpredictor.di

import com.bitcoin.predictor.bitcoinpredictor.intercator.IMainInteractor
import com.bitcoin.predictor.bitcoinpredictor.intercator.MainInteractor
import com.bitcoin.predictor.bitcoinpredictor.presenter.IMainPresenter
import com.bitcoin.predictor.bitcoinpredictor.presenter.MainPresenter
import com.bitcoin.predictor.bitcoinpredictor.utils.BitcoinPriceClassifier
import com.bitcoin.predictor.bitcoinpredictor.view.IMainView
import com.bitcoin.predictor.bitcoinpredictor.view.MainFragment
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