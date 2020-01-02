package day0

import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.JUnit4

/**
 * Created by Muzammil on 1/2/2020.
 */
internal class MeanMedianModeTest {
    lateinit var meanMedianMode: MeanMedianMode
    
    @Before
    fun setUp() {
        meanMedianMode = MeanMedianMode()
    }
    
    @Test
    fun test1() {
        val answer = meanMedianMode
                .solve(arrayOf("10", "64630 11735 14216 99233 14470 4978 73429 38120 51135 67060"))
        assert(answer.contentEquals(arrayOf("43900.6", "44627.5", "4978"))) { "Array contents are not equal" }
    }
}