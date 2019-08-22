package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0006Test {

  private data class Param(val s: String, val numRows: Int)

  private val q0006 = Q0006()
  private val list = listOf(
    Param("LEETCODEISHIRING", 3),
    Param("LEETCODEISHIRING", 4)
  )

  @Test
  fun s1() {
    list.forEach { (s, numRows) ->
      println(q0006.s1(s, numRows))
    }
  }

}