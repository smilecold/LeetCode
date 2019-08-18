package xyz.scmile.program.kotlin.leetcode

import kotlin.math.max

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
class P0003 {

  /**
   * Record all possible strings,
   * compare lengths and delete it when encountering repeated characters
   */
  fun s0(s: String): Int {
    val list = ArrayList<ArrayList<Char>>()
    var length = 0
    for (c in s) {
      list.removeIf { chars ->
        val boolean = chars.contains(c)
        if (boolean && length < chars.size) {
          length = chars.size
        }
        boolean
      }
      list.forEach { it.add(c) }
      list.add(arrayListOf(c))
    }
    list.forEach {
      if (length < it.size)
        length = it.size
    }
    return length
  }

  /**
   * Record chars with a list,
   * whenever a repeated letter is encountered,
   * calculate the length of the string and remove the part before the repeated character
   */
  fun s1(s: String): Int {
    val list = ArrayList<Char>()
    var length = 0
    s.forEach { char ->
      val index = list.indexOf(char)
      if (index != -1) {
        if (length < list.size) {
          length = list.size
        }
        list.subList(0, index + 1).clear()
      }
      list.add(char)
    }
    if (list.size > length) length = list.size
    return length
  }

  /**
   * Like s1, but use tow index instead char list
   */
  fun s2(s: String): Int {
    var length = 0
    var lo = 0
    var hi = 0
    s.forEach { c ->
      val index = s.checkRepeat(c, lo, hi)
      if (index != -1) {
        val len = hi - lo
        if (length < len) {
          length = len
        }
        lo = index + 1
      }
      hi++
    }
    val len = hi - lo
    if (length < len) {
      length = len
    }
    return length
  }

  private fun String.checkRepeat(
    c: Char,
    lo: Int,
    hi: Int
  ): Int {
    for (i in lo until hi) {
      if (this[i] == c) {
        return i
      }
    }
    return -1
  }

  /**
   * Use hash map, copied
   */
  fun s3(s: String): Int {
    var length = 0
    var lo = 0
    var hi = 0
    val map = HashMap<Char, Int>()
    s.forEach { c ->
      val value = map[c]
      if (value != null) {
        lo = max(lo, value)
      }
      map[c] = ++hi
      length = max(length, hi - lo)
    }
    return length
  }
}