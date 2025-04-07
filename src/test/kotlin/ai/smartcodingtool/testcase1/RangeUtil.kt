package ai.smartcodingtool.testcase1

/**
 * The RangeUtil class provides a method to transform integers based on specific rules:
 * - If the integer is odd, multiply it by 3.
 * - If the integer is even, divide it by 2.
 * - If the integer is a multiple of 5, multiply it by 6.
 */
class RangeUtil {

    fun get(value: Int): Int {
        return when {
            value % 5 == 0 -> value * 6
            value % 2 == 0 -> value / 2
            else -> value * 3
        }
    }
}