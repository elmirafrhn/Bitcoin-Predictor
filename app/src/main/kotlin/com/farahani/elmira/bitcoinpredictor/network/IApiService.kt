package com.farahani.elmira.bitcoinpredictor.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApiService {
    @GET("bpi/historical/close.json")
    fun getDefaulHistory(): Single<Dto.BitcoinHistory>

    @POST("https://api.coindesk.com/v1/bpi/historical/close.json")
    fun getHistoryForSpecificTime(@Body timeRange: Dto.TimeDto): Single<Dto.BitcoinHistory>
}
