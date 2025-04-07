package ai.smartcodingtool.testcase1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


/**
 * Requirements for code that does not exist on the internet and can not be reproduced by an LLM from sources that it read somewhere
 */
class RangeUtilTest {

    @Test
    fun testOddTimes3() {
        val rangeUtil = RangeUtil()
        assertEquals(9, rangeUtil.get(3))
        assertEquals(21, rangeUtil.get(7))
    }

    @Test
    fun testEvenDivideBy2() {
        val rangeUtil = RangeUtil()
        assertEquals(4, rangeUtil.get(8))
        assertEquals(6, rangeUtil.get(12))
    }

    @Test
    fun testMod5Times6() {
        val rangeUtil = RangeUtil()
        assertEquals(30, rangeUtil.get(5))
        assertEquals(60, rangeUtil.get(10))
    }
}