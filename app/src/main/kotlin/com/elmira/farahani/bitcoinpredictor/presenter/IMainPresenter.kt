package com.elmira.bitcoin.bitcoinpredictor.presenter

import com.elmira.bitcoin.bitcoinpredictor.intercator.IMainInteractor
import com.elmira.bitcoin.bitcoinpredictor.network.Dto
import com.elmira.bitcoin.bitcoinpredictor.view.IMainView

interface IMainPresenter<V : IMainView, I : IMainInteractor> {

    fun getBitcoinHistory()
    fun onAttach(baseView: V)
    fun getHistoryForSpecificTime(timeRange: Dto.TimeDto)
    fun resetModel()
}