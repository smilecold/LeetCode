package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0003Test {
  private val p0003 = Q0003()
  private val sList= listOf("abcabcbb","bbbbb","pwwkew")

  @Test
  fun s0() {
    sList.forEach { println(p0003.s3(it)) }
  }
}