package com.farahani.elmira.bitcoinpredictor.intercator

import com.farahani.elmira.bitcoinpredictor.network.IApiService
import javax.inject.Inject

open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) : IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}