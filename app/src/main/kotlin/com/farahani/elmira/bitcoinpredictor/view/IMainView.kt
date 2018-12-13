package com.farahani.elmira.bitcoinpredictor.view

import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import io.reactivex.Single

interface IMainView {

    fun showHistory(bitcoinHistoryModel: BitcoinHistoryModel)
    fun showLoading(isLoading:Boolean)
    fun showError()
    fun getDays(): Int
}
