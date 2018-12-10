package com.farahani.elmira.bitcoinpredictor

interface IMainPresenter<V : IMainView, I : IMainInteractor> {

    fun getBitcoinHistory()
    fun onAttach(baseView: V)
}