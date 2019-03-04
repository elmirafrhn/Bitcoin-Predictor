package com.elmira.farahani.bitcoinpredictor.network

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

    override fun getHistoryForSpecificTime(start: String, end: String): Single<Dto.BitcoinHistory> {
        return retrofitCreated.getHistoryForSpecificTime(start, end)
    }
}