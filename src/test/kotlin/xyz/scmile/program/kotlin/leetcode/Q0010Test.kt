package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

class Q0010Test {
  val s = arrayOf("aaa", "abcd", "aa", "aa", "ab", "aab", "mississippi")
  val p = arrayOf("a*a", "d*", "a", "a*", ".*", "c*a*b", "mis*is*p*.")
  val q0010 = Q0010()

  @Test
  fun test() {
    for (i in s.indices) {
      println("s: ${s[i]}, p: ${p[i]}, ${q0010.q2(s[i], p[i])}")
    }
  }
  @Test
  fun te1(){
    println("123"=="123")
  }
}