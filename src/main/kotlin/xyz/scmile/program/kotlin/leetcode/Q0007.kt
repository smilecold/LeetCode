package xyz.scmile.program.kotlin.leetcode

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
class Q0007 {

  /**
   * Insert single digit
   */
  fun s0(x: Int): Int {
    var num = x
    var result = 0
    while (num != 0) {
      val remainder = num % 10
      num /= 10
      val safe = result * 10L + remainder
      if (safe > Int.MAX_VALUE || safe < Int.MIN_VALUE) {
        return 0
      }
      result = safe.toInt()
    }
    return result
  }

  /**
   * Convert to string
   */
  fun s1(x: Int): Int {
    val str = StringBuilder(x.toString())
    if (str.contains('-')) {
      str.deleteCharAt(0)
      str.append('-')
    }
    val temp = str.reverse().toString().toLong()
    return if (temp < Int.MIN_VALUE || temp > Int.MAX_VALUE) 0 else temp.toInt()
  }
}