package day1

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Muzammil on 1/3/2020.
 */
internal class QuartilesTest {
    lateinit var quartiles: Quartiles
    
    @Before
    fun setUp() {
        quartiles = Quartiles()
    }
    
    @Test
    fun test1() {
        val answer = quartiles
                .solve(arrayOf("9", "3 7 8 5 12 14 21 13 18"))
        Assert.assertTrue("Array contents are not equal",
                          answer.contentEquals(arrayOf("6", "12", "16")))
    }
}