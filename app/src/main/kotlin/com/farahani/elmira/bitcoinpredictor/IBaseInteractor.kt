package com.farahani.elmira.bitcoinpredictor

import com.farahani.elmira.bitcoinpredictor.network.IApiService

interface IBaseInteractor {
    fun getApiService(): IApiService
}