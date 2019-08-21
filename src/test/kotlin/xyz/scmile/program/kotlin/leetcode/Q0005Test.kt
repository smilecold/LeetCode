package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0005Test {
  private val q0005 = Q0005()
  private val list = listOf("babad", "cbbd", "abcba")
  @Test
  fun s0() {
    list.forEach { println(q0005.s4(it)) }
  }
}