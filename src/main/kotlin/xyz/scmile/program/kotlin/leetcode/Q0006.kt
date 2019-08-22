package xyz.scmile.program.kotlin.leetcode

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串
 */
class Q0006 {

  /**
   * Violence
   */
  fun s0(s: String, numRows: Int): String {
    if (numRows == 1) return s
    val list = Array(numRows) { _ -> ArrayList<Char>() }
    val size = 2 * numRows - 2
    val index = List(size) { i ->
      if (i > numRows - 1) size - i
      else i
    }
    s.forEachIndexed { i, c ->
      list[index[i % (size)]].add(c)
    }
    val builder = StringBuilder(s.length)
    list.forEach { arrayList ->
      arrayList.forEach {
        builder.append(it)
      }
    }
    return builder.toString()
  }

  /**
   * Foreach line
   */
  fun s1(s: String, numRows: Int): String {
    if (numRows == 1) return s
    val builder = StringBuilder(s.length)
    val size = 2 * numRows - 2
    val line = s.length / size
    for (i in 0 until numRows) {
      when (i) {
        0, numRows - 1 -> for (j in 0..line) {
          val index = j * size + i
          if (index >= s.length) break
          builder.append(s[index])
        }
        else -> for (j in 0..line) {
          val index0 = j * size + i
          if (index0 >= s.length) break
          builder.append(s[index0])
          val index1 = j * size + size - i
          if (index1 >= s.length) break
          builder.append(s[index1])
        }
      }
    }
    return builder.toString()
  }
}