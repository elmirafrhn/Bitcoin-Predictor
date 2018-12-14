package com.bitcoin.predictor.bitcoinpredictor.presenter

import com.bitcoin.predictor.bitcoinpredictor.intercator.IMainInteractor
import com.bitcoin.predictor.bitcoinpredictor.network.Dto
import com.bitcoin.predictor.bitcoinpredictor.view.IMainView

interface IMainPresenter<V : IMainView, I : IMainInteractor> {

    fun getBitcoinHistory()
    fun onAttach(baseView: V)
    fun getHistoryForSpecificTime(timeRange: Dto.TimeDto)
    fun resetModel()
}