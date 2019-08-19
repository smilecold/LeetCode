package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class Q0002Test {
  val p0002 = Q0002()
  val l1: Q0002.ListNode
  val l2: Q0002.ListNode

  init {
    l1 = Q0002.ListNode(2)
    l1.next = Q0002.ListNode(4)
    l1.next?.next = Q0002.ListNode(3)
    l2 = Q0002.ListNode(5)
    l2.next = Q0002.ListNode(6)
    l2.next?.next = Q0002.ListNode(4)
  }

  @Test
  fun s0() {
    println(p0002.s0(l1, l2))
  }
}