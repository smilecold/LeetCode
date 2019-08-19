package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0004Test {

  private val p0004 = Q0004()
  private val nums = listOf(
    Pair(intArrayOf(1, 3), intArrayOf(2)),
    Pair(intArrayOf(1, 2), intArrayOf(3, 4)),
    Pair( intArrayOf(2), intArrayOf())
  )

  @Test
  fun s0() {
    nums.forEach {
      println(p0004.s2(it.first, it.second))
    }
  }

}