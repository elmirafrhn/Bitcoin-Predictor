package com.farahani.elmira.bitcoinpredictor.network

import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject
constructor(retrofit: Retrofit) : IApiService {
    private val retrofitCreated = retrofit.create(IApiService::class.java)
    override fun getDefaulHistory(): Single<Dto.BitcoinHistory> {
        return retrofitCreated.getDefaulHistory()
    }

    override fun getHistoryForSpecificTime(timeRange: Dto.TimeDto): Single<Dto.BitcoinHistory> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}