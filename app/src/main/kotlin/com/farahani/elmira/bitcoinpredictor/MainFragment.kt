package com.farahani.elmira.bitcoinpredictor

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.row_item.*
import javax.inject.Inject


class MainFragment @Inject constructor() : DaggerFragment(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter<IMainView, IMainInteractor>

    var daysCount: Int = 5

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner()
        initRecyclerView()
        presenter.getBitcoinHistory()
    }

    override fun showHistory(bitcoinHistoryModel: BitcoinHistoryModel) {
        val priceDateArray = bitcoinHistoryModel.bpi.toString()
            .replace("{", "")
            .replace("}", "")
            .split(",")

        val priceArray = ArrayList<String>()
        for (item in priceDateArray.subList(priceDateArray.size - daysCount, priceDateArray.size)) {
            priceArray.add(item.split("=")[1])
        }

        val adapter = BitcoinDaysAdapter(priceArray)
        recyclerViewDaysBitcoin.adapter = adapter
        buttonPredict.isEnabled = true
        buttonPredict.setOnClickListener { _ ->
            textViewPredictedResult.text =
                    String.format(resources.getString(R.string.predictedResult), priceArray[0], "LOWER")
        }
    }

    override fun showLoading(isLoading: Boolean) {

        when (isLoading) {
            true -> apply {
                progressBar.visibility = View.VISIBLE
                textViewNoApiResponse.visibility = View.GONE
            }
            false -> apply {
                progressBar.visibility = View.GONE
                textViewNoApiResponse.visibility = View.GONE
            }
        }
    }

    override fun showError() {
        textViewNoApiResponse.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    private fun initSpinner() {
        val spinnerAdapter =
            ArrayAdapter.createFromResource(activity!!, R.array.days, R.layout.spinner_item)
        spinnerDays.adapter = spinnerAdapter
        spinnerDays.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>, v: View, i: Int, lng: Long) {
                val stringArray = resources.getStringArray(R.array.days)
                daysCount = when (adapter.getItemAtPosition(i).toString()) {
                    stringArray[0] -> 5
                    stringArray[1] -> 6
                    stringArray[2] -> 7
                    else ->
                        5
                }
                presenter.getBitcoinHistory()
                textViewDaysResult.text = String.format(resources.getString(R.string.resultDays), daysCount)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {

            }
        }
    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(activity, 3)
        recyclerViewDaysBitcoin.layoutManager = layoutManager
    }

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }
}