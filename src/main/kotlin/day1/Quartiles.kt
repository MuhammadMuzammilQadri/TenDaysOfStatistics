package day1

import kotlin.math.ceil

/**
 * Created by Muzammil on 1/2/2020.
 */

/**
 * Just for printing output to STDOUT, as it was a submission requirement on HackerRank
 */
fun main(args: Array<String>) {
    Quartiles().solve(arrayOf(readLine()!!,
                              readLine()!!)).forEach {
        println(it)
    }
}

class Quartiles {
    
    fun solve(args: Array<String>): Array<String> {
        val elements = sortAscendingly(args[1].split(" ").map { it.toInt() })
        val lowerHalf = elements.subList(0, elements.size / 2)
        val upperHalf = elements.subList(ceil(elements.size / 2.0).toInt(), elements.size)
        val firstQuartile = computeMedian(lowerHalf)
        val secondQuartile = computeMedian(elements)
        val thirdQuartile = computeMedian(upperHalf)
        return arrayOf(firstQuartile, secondQuartile, thirdQuartile)
                .map { String.format("%.0f", it) }.toTypedArray()
    }
    
    private fun computeMedian(elements: List<Int>): Double {
        return elements.run {
            when {
                size % 2 == 0 -> (this[(size / 2) - 1] + this[size / 2]) / 2.0
                size % 2 == 1 -> this[size / 2].toDouble()
                else             -> 0.0
            }
        }
    }
    
    private fun sortAscendingly(elements: List<Int>): List<Int> {
        return elements.sortedWith(Comparator { a, b ->
            when {
                a > b -> 1
                a < b -> -1
                else  -> 0
            }
        })
    }
}