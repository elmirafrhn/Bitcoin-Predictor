package com.farahani.elmira.bitcoinpredictor

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V : IMainView, I : IMainInteractor> @Inject constructor(
    interactor: I
) : IMainPresenter<V, I> {
    var mbaseInteractor: I? = null
        private set
    var mbaseView: V? = null
        private set

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
        val compositeDisposable = CompositeDisposable()
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
                    Log.d("apiError", throwable.message)
                })
        )
    }
}