package com.elmira.bitcoin.bitcoinpredictor.view

import com.elmira.bitcoin.bitcoinpredictor.model.BitcoinHistoryModel

interface IMainView {

    fun showResult(bitcoinHistoryModel: BitcoinHistoryModel, predictedResult:Double)
    fun showLoading(isLoading:Boolean)
    fun showError()
    fun getDays(): Int
}
