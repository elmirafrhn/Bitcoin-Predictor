package com.farahani.elmira.bitcoinpredictor.view

import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import io.reactivex.Single

interface IMainView {

    fun showResult(bitcoinHistoryModel: BitcoinHistoryModel,predictedResult:Double)
    fun showLoading(isLoading:Boolean)
    fun showError()
    fun getDays(): Int
}
