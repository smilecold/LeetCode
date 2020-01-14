package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0009Test {
  private val q0009 = Q0009()
  private val list = listOf(121, -121, 10)
  @Test
  fun s0() {
    list.forEach {
      println(q0009.s1(it))
    }
  }
}