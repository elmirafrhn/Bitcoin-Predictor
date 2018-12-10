package com.farahani.elmira.bitcoinpredictor

import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import io.reactivex.Single

interface IMainView {

    fun showHistory(bitcoinHistoryModel: BitcoinHistoryModel)

}
