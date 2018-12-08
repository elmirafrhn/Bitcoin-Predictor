package com.farahani.elmira.bitcoinpredictor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    val list = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        listViewDaysBitcoin.layoutManager = layoutManager
        for (i in 3000..3004) {
            list.add(i.toString())
        }
        val adapter = BitcoinDaysAdapter(list)
        listViewDaysBitcoin.adapter = adapter
    }

    companion object {
        fun newInstance(): Fragment {
            return MainFragment()
        }
    }
}