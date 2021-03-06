package com.elmira.farahani.bitcoinpredictor.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.elmira.farahani.bitcoinpredictor.R
import com.elmira.farahani.bitcoinpredictor.intercator.IMainInteractor
import com.elmira.farahani.bitcoinpredictor.model.BitcoinHistoryModel
import com.elmira.farahani.bitcoinpredictor.network.Dto
import com.elmira.farahani.bitcoinpredictor.presenter.IMainPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
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
        presenter.getHistoryForSpecificTime(
            Dto.TimeDto(
                resources.getString(R.string.start),
                resources.getString(R.string.end)
            )
        )
        textViewPredictedResult.text = String.format(
                resources.getString(R.string.predictedResult),
        "{ price }",
        "..."
        )
    }

    override fun showResult(bitcoinHistoryModel: BitcoinHistoryModel, predictedResult: Double) {

        val adapter = BitcoinDaysAdapter(
            bitcoinHistoryModel.bpi.subList(
                bitcoinHistoryModel.bpi.size-(daysCount+1),
                bitcoinHistoryModel.bpi.size-1
            )
        )
        recyclerViewDaysBitcoin.adapter = adapter
        buttonPredict.isEnabled = true
        buttonPredict.setOnClickListener { _ ->

            presenter.getHistoryForSpecificTime(
                Dto.TimeDto(
                    resources.getString(R.string.start),
                    resources.getString(R.string.end)
                )
            )

            textViewPredictedResult.text =
                    when (bitcoinHistoryModel.bpi[bitcoinHistoryModel.bpi.size - 1].compareTo(predictedResult)) {
                        -1 -> {
                            String.format(
                                resources.getString(R.string.predictedResult),
                                "<p><font color='#1A237E'>" + predictedResult.toString() + "</font></p>",
                                "<font color='#1A237E'>higher</font>"
                            )
                        }
                        0 -> {
                            String.format(
                                resources.getString(R.string.predictedResult),
                                "<p><font color='#1A237E'>" + predictedResult.toString() + "</font></p>",
                                "<font color='#1A237E'>equal</font>"
                            )
                        }
                        1 -> {
                            Html.fromHtml(
                                String.format(
                                    resources.getString(R.string.predictedResult),
                                    "<p><font color='#1A237E'>" + predictedResult.toString() + "</font></p>",
                                    "<font color='#1A237E'>lower</font>"
                                )
                            )
                        }
                        else -> {
                            Html.fromHtml(
                                String.format(
                                    resources.getString(R.string.predictedResult),
                                    "<p><font color='#1A237E'>" + predictedResult.toString() + "</font></p>",
                                    "<font color='#1A237E'>{ no data }</font>"
                                )
                            )
                        }
                    }
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

    override fun getDays(): Int = daysCount

    private fun setDays(days: Int): Int {
        daysCount = days
        return daysCount
    }

    private fun initSpinner() {
        val spinnerAdapter =
            ArrayAdapter.createFromResource(
                activity!!.applicationContext,
                R.array.days,
                R.layout.spinner_item
            )
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
                setDays(daysCount)
                presenter.resetModel()
                presenter.getHistoryForSpecificTime(
                    Dto.TimeDto(
                        resources.getString(R.string.start),
                        resources.getString(R.string.end)
                    )
                )
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