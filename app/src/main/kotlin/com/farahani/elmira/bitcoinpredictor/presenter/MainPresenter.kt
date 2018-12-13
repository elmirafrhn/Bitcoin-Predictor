package com.farahani.elmira.bitcoinpredictor.presenter

import android.util.Log
import com.farahani.elmira.bitcoinpredictor.intercator.IMainInteractor
import com.farahani.elmira.bitcoinpredictor.network.Dto
import com.farahani.elmira.bitcoinpredictor.utils.BitcoinPriceClassifier
import com.farahani.elmira.bitcoinpredictor.utils.map
import com.farahani.elmira.bitcoinpredictor.view.IMainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V : IMainView, I : IMainInteractor> @Inject constructor(
    interactor: I
) : IMainPresenter<V, I> {

    @Inject
    lateinit var bitcoinPriceClassifier: BitcoinPriceClassifier

    var mbaseInteractor: I? = null
        private set
    var mbaseView: V? = null
        private set
    val compositeDisposable = CompositeDisposable()

    init {
        mbaseInteractor = interactor
    }

    override fun onAttach(baseView: V) {
        mbaseView = baseView
    }

    private fun getInteractor(): I? {
        return mbaseInteractor
    }

    private fun getView(): V? {
        return mbaseView
    }

    override fun getBitcoinHistory() {

        getView()?.showLoading(true)
        compositeDisposable.add(
            getInteractor()!!.getDefaultHistoryData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    val list = data.map()
                    list?.let {
                        getView()?.showHistory(list)
                    }
                    getView()?.showLoading(false)

                }, { throwable ->
                    getView()?.showError()
                    Log.d("DefaultError", throwable.message)
                })
        )
    }

    override fun getHistoryForSpecificTime(timeRange: Dto.TimeDto) {
        getView()?.showLoading(true)
        compositeDisposable.add(
            getInteractor()!!.getHistoryForSpecificTime(timeRange)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    val list = data.map()
                    list?.let {
                        bitcoinPriceClassifier.classify(list.bpi,getView()!!.getDays())
                        getView()?.showHistory(list)
                    }
                    getView()?.showLoading(false)
                }
                    , { throwable ->
                        getView()!!.showError()
                        Log.d("ForSpecificTimeError", throwable.message)
                    })
        )
    }
}