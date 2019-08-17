package xyz.scmile.program.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class P0002Test {
  val p0002 = P0002()
  val l1: P0002.ListNode
  val l2: P0002.ListNode

  init {
    l1 = P0002.ListNode(2)
    l1.next = P0002.ListNode(4)
    l1.next?.next = P0002.ListNode(3)
    l2 = P0002.ListNode(5)
    l2.next = P0002.ListNode(6)
    l2.next?.next = P0002.ListNode(4)
  }

  @Test
  fun s0() {
    println(p0002.s0(l1, l2))
  }
}