package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test
private val nums= intArrayOf(2, 7, 11, 15)
private const val target = 9
internal class P1Test {

  @Test
  fun s0() {
    val result = P1().s0(nums, target)
    println(result.toList())
  }

  @Test
  fun s1(){
    println(P1().s1(nums, target).toList())
  }
}