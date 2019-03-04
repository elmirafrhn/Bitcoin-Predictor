package com.elmira.farahani.bitcoinpredictor.intercator

import com.elmira.farahani.bitcoinpredictor.network.Dto
import com.elmira.farahani.bitcoinpredictor.network.IApiService
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor @Inject constructor(
    apiService: IApiService
) : BaseInteractor(apiService),
    IMainInteractor {
    override fun getDefaultHistoryData(): Single<Dto.BitcoinHistory> {
        return getApiService().getDefaulHistory()
    }

    override fun getHistoryForSpecificTime(timeRange: Dto.TimeDto): Single<Dto.BitcoinHistory> {
        return getApiService().getHistoryForSpecificTime(timeRange.start,timeRange.end)
    }
}