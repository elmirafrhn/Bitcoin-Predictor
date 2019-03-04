package com.elmira.farahani.bitcoinpredictor.intercator

import com.elmira.farahani.bitcoinpredictor.network.IApiService
import javax.inject.Inject

open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) :
    IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}