package xyz.scmile.program.kotlin.leetcode

import kotlin.math.min

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 */
class Q0005 {

  /**
   * Violence
   * O(n^3)
   */
  fun s0(s: String): String {
    var result = ""
    val list = Array(s.length) { StringBuilder() }
    s.forEachIndexed { i, c ->
      for (j in 0..i) {
        list[j].append(c)
        if (result.length < list[j].length && palindrome0(list[j])) {
          result = list[j].toString()
        }
      }
    }
    return result
  }

  /**
   * O(n)
   */
  private fun palindrome0(s: CharSequence): Boolean {
    val length = s.length
    for (i in 0 until length / 2) {
      if (s[i] != s[length - 1 - i]) {
        return false
      }
    }
    return true
  }

  /**
   * Record char location, check string in same char
   * O(n^3)
   */
  fun s1(s: String): String {
    val map = HashMap<Char, ArrayList<Int>>(s.length)
    var result = ""
    s.forEachIndexed { i, c ->
      if (!map.containsKey(c)) map[c] = ArrayList()
      val list = map[c] as ArrayList
      list.add(i)
      list.forEach {
        val length = i - it + 1
        if (result.length < length && palindrome1(s, it + 1, length - 2)) {
          result = s.substring(it, i + 1)
        }
      }
    }
    return result
  }

  /**
   * O(n)
   */
  private fun palindrome1(s: CharSequence, lo: Int, length: Int): Boolean {
    for (i in 0 until length / 2) {
      if (s[i + lo] != s[length - 1 - i + lo]) {
        return false
      }
    }
    return true
  }

  /**
   * Common string
   * O(n^2)
   */
  fun s2(s: String): String {
    var result = ""
    val temp = StringBuilder()
    for (row in s.indices) {
      var i = row
      for (j in s.indices.reversed()) {
        if (i == s.length) {
          break
        }
        if (s[i] == s[j]) {
          temp.append(s[i])
          if (result.length < temp.length && i - temp.length + 1 == j) result = temp.toString()
        } else {
          temp.clear()
        }
        i++
      }
    }

    return result
  }

  /**
   * Expand with small string
   */
  fun s3(s: String): String {
    var result = ""
    for (i in s.indices) {
      result = expand(i, i, s, result.length) ?: result
      result = expand(i, i + 1, s, result.length) ?: result
    }
    return result
  }

  /**
   * O(n)
   */
  private fun expand(
    l: Int,
    r: Int,
    s: String,
    length: Int
  ): String? {
    var l1 = l
    var r1 = r
    while (true) {
      if (l1 < 0 || r1 == s.length || s[l1] != s[r1]) {
        if (r1 - l1 - 1 > length) {
          return s.substring(l1 + 1, r1)
        }
        break
      } else {
        l1--
        r1++
      }
    }
    return null
  }

  /**
   * Manacher copied
   * O(n)
   */
  fun s4(s: String): String {
    val builder = StringBuilder()
    s.forEach {
      builder.append('#')
      builder.append(it)
    }
    builder.append('#')
    val sn = builder.toString()
    val p = IntArray(sn.length)
    var pos = 0
    var mr = 0
    var result = ""
    sn.indices.forEach { i ->
      if (i < mr)
        p[i] = min(p[2 * pos - i], mr - i)
      else
        p[i] = 1
      while (i >= p[i] && i + p[i] < sn.length && sn[i - p[i]] == sn[i + p[i]])
        p[i]++
      if (p[i] - 1 + i > mr) {
        mr = p[i] - 1 + i
        pos = i
      }
      if (result.length < p[i] - 1)
        result = s.substring((i - p[i] + 1) / 2, (i + p[i] - 1) / 2)
    }
    return result
  }
}