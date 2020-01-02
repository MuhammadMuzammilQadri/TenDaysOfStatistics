package day0

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Muzammil on 1/2/2020.
 */
internal class WeightedMeanTest {
    
    lateinit var weightedMean: WeightedMean
    
    @Before
    fun setUp() {
        weightedMean = WeightedMean()
    }
    
    @Test
    fun test1() {
        val answer = weightedMean
                .solve(arrayOf("5", "10 40 30 50 20", "1 2 3 4 5"))
        Assert.assertEquals("Array contents are not equal", "32.0", answer)
    }
    
    @Test
    fun test2() {
        val answer = weightedMean
                .solve(arrayOf("4", "88 71 97 90", "25 30 10 35"))
        Assert.assertEquals("Array contents are not equal", "84.5", answer)
    }
    
    @Test
    fun test3() {
        val answer = weightedMean
                .solve(arrayOf("3", "1 3 5", "2 4 6"))
        Assert.assertEquals("Array contents are not equal", "3.7", answer)
    }
}