package com.farahani.elmira.bitcoinpredictor.presenter

import com.farahani.elmira.bitcoinpredictor.intercator.IMainInteractor
import com.farahani.elmira.bitcoinpredictor.network.Dto
import com.farahani.elmira.bitcoinpredictor.view.IMainView

interface IMainPresenter<V : IMainView, I : IMainInteractor> {

    fun getBitcoinHistory()
    fun onAttach(baseView: V)
    fun getHistoryForSpecificTime(timeRange: Dto.TimeDto)
    fun resetModel()
}