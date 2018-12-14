package com.bitcoin.predictor.bitcoinpredictor.intercator

import com.bitcoin.predictor.bitcoinpredictor.network.Dto
import io.reactivex.Single

interface IMainInteractor {

    fun getDefaultHistoryData(): Single<Dto.BitcoinHistory>
    fun getHistoryForSpecificTime(timRange: Dto.TimeDto): Single<Dto.BitcoinHistory>
}