package com.farahani.elmira.bitcoinpredictor

import com.farahani.elmira.bitcoinpredictor.network.Dto
import io.reactivex.Single

interface IMainInteractor {

    fun getDefaultHistoryData(): Single<Dto.BitcoinHistory>
}