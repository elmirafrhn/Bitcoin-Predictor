package com.farahani.elmira.bitcoinpredictor

import com.farahani.elmira.bitcoinpredictor.network.Dto
import com.farahani.elmira.bitcoinpredictor.network.IApiService
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor @Inject constructor(
    apiService: IApiService) : BaseInteractor(apiService),IMainInteractor{
    override fun getDefaultHistoryData(): Single<Dto.BitcoinHistory> {
        return getApiService().getDefaulHistory()
    }
}