package com.elmira.farahani.bitcoinpredictor.intercator

import com.elmira.farahani.bitcoinpredictor.network.Dto
import io.reactivex.Single

interface IMainInteractor {

    fun getDefaultHistoryData(): Single<Dto.BitcoinHistory>
    fun getHistoryForSpecificTime(timRange: Dto.TimeDto): Single<Dto.BitcoinHistory>
}