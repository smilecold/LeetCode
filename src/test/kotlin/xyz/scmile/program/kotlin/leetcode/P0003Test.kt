package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class P0003Test {
  private val p0003 = P0003()
  private val sList= listOf("abcabcbb","bbbbb","pwwkew")

  @Test
  fun s0() {
    sList.forEach { println(p0003.s3(it)) }
  }
}