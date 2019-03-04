package com.elmira.bitcoin.bitcoinpredictor.intercator

import com.elmira.bitcoin.bitcoinpredictor.network.Dto
import io.reactivex.Single

interface IMainInteractor {

    fun getDefaultHistoryData(): Single<Dto.BitcoinHistory>
    fun getHistoryForSpecificTime(timRange: Dto.TimeDto): Single<Dto.BitcoinHistory>
}