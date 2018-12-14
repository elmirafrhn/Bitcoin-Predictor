package com.bitcoin.predictor.bitcoinpredictor.view

import com.bitcoin.predictor.bitcoinpredictor.model.BitcoinHistoryModel

interface IMainView {

    fun showResult(bitcoinHistoryModel: BitcoinHistoryModel, predictedResult:Double)
    fun showLoading(isLoading:Boolean)
    fun showError()
    fun getDays(): Int
}
