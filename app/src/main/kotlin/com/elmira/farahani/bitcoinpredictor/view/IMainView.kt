package com.elmira.farahani.bitcoinpredictor.view

import com.elmira.farahani.bitcoinpredictor.model.BitcoinHistoryModel

interface IMainView {

    fun showResult(bitcoinHistoryModel: BitcoinHistoryModel, predictedResult:Double)
    fun showLoading(isLoading:Boolean)
    fun showError()
    fun getDays(): Int
}
