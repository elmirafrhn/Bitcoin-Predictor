package com.bitcoin.predictor.bitcoinpredictor.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("bpi/historical/close.json")
    fun getDefaulHistory(): Single<Dto.BitcoinHistory>

    @GET("bpi/historical/close.json")
    fun getHistoryForSpecificTime(
        @Query("start") start:String,
        @Query("end") end: String
    ): Single<Dto.BitcoinHistory>
}
