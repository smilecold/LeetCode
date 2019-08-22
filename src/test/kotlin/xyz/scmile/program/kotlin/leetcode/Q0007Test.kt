package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0007Test {
  private val list = listOf(123, -123, 120)
  @Test
  fun s0() {
    list.forEach {
      println(Q0007().s1(it))
    }
  }
}