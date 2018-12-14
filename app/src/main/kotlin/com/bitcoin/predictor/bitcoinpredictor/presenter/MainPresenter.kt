package com.bitcoin.predictor.bitcoinpredictor.presenter

import android.util.Log
import com.bitcoin.predictor.bitcoinpredictor.intercator.IMainInteractor
import com.bitcoin.predictor.bitcoinpredictor.network.Dto
import com.bitcoin.predictor.bitcoinpredictor.utils.BitcoinPriceClassifier
import com.bitcoin.predictor.bitcoinpredictor.utils.map
import com.bitcoin.predictor.bitcoinpredictor.view.IMainView
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

    private fun getInteractor(): I? {
        return mbaseInteractor
    }

    private fun getView(): V? {
        return mbaseView
    }

    override fun onAttach(baseView: V) {
        mbaseView = baseView
    }

    override fun resetModel() {
        bitcoinPriceClassifier.reset()
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
                        getView()?.showResult(list, 0.0)
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
                        getView()?.showResult(list, bitcoinPriceClassifier.classify(list.bpi, getView()!!.getDays()))
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