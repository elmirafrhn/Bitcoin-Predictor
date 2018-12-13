package com.farahani.elmira.bitcoinpredictor.utils

import android.util.Log
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier
import javax.inject.Inject

class BitcoinPriceClassifier @Inject constructor() {

    val beyas = BayesClassifier<Double, Double>()

    fun classify(list: List<Double>, daysCount: Int) {

        val categoriesArray = doubleArrayOf(-500.0, -100.0, -50.0, -10.0, 0.0, 10.0, 50.0, 100.0, 500.0)

        list.forEachIndexed { index, item ->
            Log.d("elmiraa", index.toString())
            if (index >= list.size - daysCount) return@forEachIndexed
            var setList = list.subList(index, daysCount + index - 1)
            var category = list[daysCount + index - 1] - setList[setList.size - 1]

            beyas.learn(findNearestCategoryLabel(category, categoriesArray), setList)

        }
        Log.d(
            "beyasResult",
            (beyas.classify(
                list.subList(
                    list.size - daysCount - 1,
                    list.size - 1
                )
            ).category + list[list.size - 1]).toString()
        )
    }

    private fun findNearestCategoryLabel(value: Double, a: DoubleArray): Double {

        if (value < a[0]) {
            return a[0]
        }
        if (value > a[a.size - 1]) {
            return a[a.size - 1]
        }

        var lo = 0
        var hi = a.size - 1

        while (lo <= hi) {
            val mid = (hi + lo) / 2

            if (value < a[mid]) {
                hi = mid - 1
            } else if (value > a[mid]) {
                lo = mid + 1
            } else {
                return a[mid]
            }
        }
        return if (a[lo] - value < value - a[hi]) a[lo] else a[hi]
    }

    private fun makeCategoriesLabelSet(count: Int, start: Double, end: Double, stepNum: Double): DoubleArray {
        val array = doubleArrayOf()
        for (i in start.toInt()..end.toInt()) {
            array[i] = start * stepNum
        }
        return array
    }
}