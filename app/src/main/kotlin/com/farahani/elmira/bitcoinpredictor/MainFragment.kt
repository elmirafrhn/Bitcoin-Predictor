package com.farahani.elmira.bitcoinpredictor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import dagger.android.support.DaggerFragment
import io.reactivex.Single
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment @Inject constructor() : DaggerFragment(), IMainView {
    @Inject
    lateinit var presenter: IMainPresenter<IMainView,IMainInteractor>

    override fun showHistory(bitcoinHistoryModel: BitcoinHistoryModel) {
//        for(){
        val str=bitcoinHistoryModel.bpi.toString().replace("{","").split(",")
            Log.d("elmiraa",str [0])
//        }
    }
    val list = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        listViewDaysBitcoin.layoutManager = layoutManager
        for (i in 3000..3004) {
            list.add(i.toString())
        }

        presenter.getBitcoinHistory()
        val adapter = BitcoinDaysAdapter(list)
        listViewDaysBitcoin.adapter = adapter
    }

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }
}