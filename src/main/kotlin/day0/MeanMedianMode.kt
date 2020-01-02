package day0

/**
 * Created by Muzammil on 1/2/2020.
 */

/**
 * Just for printing output to STDOUT, as it was a submission requirement on HackerRank
 */
fun main(args: Array<String>) {
    MeanMedianMode().solve(arrayOf(readLine()!!,
                                   readLine()!!)).forEach {
        println(it)
    }
}

class MeanMedianMode {
    
    fun solve(args: Array<String>): Array<String> {
        val elements = args[1].split(" ").map { it.toInt() }
        val mean = computeMean(elements, args)
        val median = computeMedian(elements)
        val mode = computeMode(elements)
        return arrayOf(mean.toString(), median.toString(), mode.toString())
    }
    
    private fun computeMean(elements: List<Int>,
                            args: Array<String>) = elements.reduce { acc, element -> acc + element }
                                                           .toInt() / args[0].toDouble()
    
    private fun computeMedian(elements: List<Int>): Double {
        return elements.sortedWith(Comparator { a, b ->
            when {
                a > b -> 1
                a < b -> -1
                else  -> 0
            }
        }).let {
            when {
                it.size % 2 == 0 -> (it[(it.size / 2) - 1] + it[it.size / 2]) / 2.0
                it.size % 2 == 1 -> it[it.size / 2].toDouble()
                else             -> 0.0
            }
        }
    }
    
    private fun computeMode(elements: List<Int>): Int {
        val numOfOccurrenceMap = mutableMapOf<Int, Int>()
        elements.forEach {
            numOfOccurrenceMap[it] = numOfOccurrenceMap.getOrDefault(it, 0) + 1
        }
        
        var element: Int? = null
        var numberOfOccuranceOfElement: Int? = null
        numOfOccurrenceMap.forEach {
            if (it.value > (numberOfOccuranceOfElement ?: 0)
                || (it.value == numberOfOccuranceOfElement ?: 0
                    && element ?: 0 > it.key)) {
                element = it.key
                numberOfOccuranceOfElement = it.value
            }
        }
        return element ?: 0
    }
}