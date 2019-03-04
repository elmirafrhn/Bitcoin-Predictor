package com.elmira.farahani.bitcoinpredictor.intercator

import com.elmira.farahani.bitcoinpredictor.network.IApiService

interface IBaseInteractor {
    fun getApiService(): IApiService
}