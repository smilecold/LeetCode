package xyz.scmile.program.kotlin.leetcode

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
class Q0009 {

  /**
   * 转化为字符串
   */
  fun s0(x: Int): Boolean {
    val str = x.toString()
    var l = 0
    var h = str.length - 1
    while (l <= h) {
      if (str[l] != str[h]) return false
      l++
      h--
    }
    return true
  }

  /**
   * 不转化为字符串
   */
  fun s1(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false
    }
    var num = x
    var n = 0
    while (num > n) {
      n = n * 10 + num % 10
      num /= 10
    }
    return num == n || num == n / 10
  }
}
