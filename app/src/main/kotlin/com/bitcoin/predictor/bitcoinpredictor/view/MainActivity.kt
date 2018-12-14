package com.bitcoin.predictor.bitcoinpredictor.view

import android.os.Bundle
import com.bitcoin.predictor.bitcoinpredictor.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMainFragment()
    }

    private fun startMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, MainFragment.newInstance()).commit()
    }
}