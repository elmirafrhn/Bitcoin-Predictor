package com.farahani.elmira.bitcoinpredictor.intercator

import com.farahani.elmira.bitcoinpredictor.network.IApiService

interface IBaseInteractor {
    fun getApiService(): IApiService
}