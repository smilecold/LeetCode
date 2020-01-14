package xyz.scmile.program.kotlin.leetcode

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
class Q0008 {

  /**
   * 挨个case
   */
  fun s0(str: String): Int {
    val charToNum = IntRange(0, 9).associateBy { it.toString()[0] }
    var positive = 1
    var num = 0
    var len = -1
    loop@ for (i in str) {
      when (i) {
        ' ' -> {
          if (len != -1) break@loop
        }
        '-' -> {
          if (len != -1) break@loop
          else {
            len = 0
            positive = -1
          }
        }
        '+' -> {
          if (len != -1) break@loop
          else len = 0
        }
        else -> {
          val n = charToNum[i] ?: break@loop
          if (len >= 10 || len == 9 && (num > 214748364 || num == 214748364 && n > 7)) {
            return if (positive == 1)
              2147483647
            else -2147483648
          }
          if (n == 0) {
            if (len == -1) len = 0
            if (len >= 1) {
              len++
              num *= 10
            }
            continue@loop
          }
          if (len == -1) {
            len = 0
          }
          len++
          num = num * 10 + n
        }
      }
    }
    return num * positive
  }

  /**
   * 优化方法1
   */
  fun s1(str: String): Int {
    var pos = 1
    var num = 0L
    var index = 0
    while (index < str.length && str[index] == ' ') index++
    if (index == str.length) return 0
    when (str[index]) {
      '+' -> index++
      '-' -> {
        pos = -1
        index++
      }
      !in '0'..'9' -> {
        return 0
      }
    }
    loop@ for (i in index until str.length) {
      when (val n = str[i] - '0') {
        in 0..9 -> {
          num = num * 10 + n
          val l = num - Int.MAX_VALUE
          if (l > 0) {
            if (pos == 1) {
              return Int.MAX_VALUE
            } else if (l > 1) {
              return Int.MIN_VALUE
            }
          }
        }
        else -> {
          break@loop
        }
      }
    }
    return (num * pos).toInt()
  }
}
