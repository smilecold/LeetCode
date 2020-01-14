package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

class Q0008Test {
  private val q0008 = Q0008()
  private val list = arrayOf("42", "   -42", "4193 with words", "words and 987", "-91283472332","2147483646","2147483648","2147483800","dfgsdf","   ")

  @Test
  fun t0() {
    list.associate { it to q0008.s1(it) }
      .forEach {
      println(it)
    }
  }
}