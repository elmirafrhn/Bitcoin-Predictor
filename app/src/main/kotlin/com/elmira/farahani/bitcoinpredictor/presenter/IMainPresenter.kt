package com.elmira.farahani.bitcoinpredictor.presenter

import com.elmira.farahani.bitcoinpredictor.intercator.IMainInteractor
import com.elmira.farahani.bitcoinpredictor.network.Dto
import com.elmira.farahani.bitcoinpredictor.view.IMainView

interface IMainPresenter<V : IMainView, I : IMainInteractor> {

    fun getBitcoinHistory()
    fun onAttach(baseView: V)
    fun getHistoryForSpecificTime(timeRange: Dto.TimeDto)
    fun resetModel()
}