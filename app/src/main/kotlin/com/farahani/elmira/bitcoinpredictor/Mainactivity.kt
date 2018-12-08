package com.farahani.elmira.bitcoinpredictor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Mainactivity : AppCompatActivity() {

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