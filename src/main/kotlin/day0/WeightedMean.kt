package day0

/**
 * Created by Muzammil on 1/2/2020.
 */

/**
 * Just for printing output to STDOUT, as it was a submission requirement on HackerRank
 */
fun main(args: Array<String>) {
    WeightedMean().solve(arrayOf(readLine()!!,
                                 readLine()!!,
                                 readLine()!!)).let {
        println(it)
    }
}

class WeightedMean {
    
    fun solve(args: Array<String>): String {
        val elements = args[1].split(" ").map { it.toInt() }
        val weights = args[2].split(" ").map { it.toInt() }
        return String.format("%.1f", computeWeightedMean(elements, weights))
    }
    
    private fun computeWeightedMean(elements: List<Int>,
                                    weights: List<Int>): Double {
        return elements.toMutableList().let { mutableList ->
            mutableList.forEachIndexed { index, element ->
                mutableList[index] = element * weights[index]
            }
            aggregationOfElementIntoWeights(mutableList) / aggregationOfWeights(weights)
        }
    }
    
    private fun aggregationOfWeights(weights: List<Int>) =
            weights.reduce { acc, weight -> acc + weight }.toDouble()
    
    private fun aggregationOfElementIntoWeights(mutableList: MutableList<Int>): Int {
        return mutableList
                .reduce { acc, element -> acc + element }
                .toInt()
    }
}