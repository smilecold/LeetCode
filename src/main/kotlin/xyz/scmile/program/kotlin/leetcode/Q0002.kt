package xyz.scmile.program.kotlin.leetcode

class Q0002 {
  class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
      val builder = StringBuilder()
      var next: ListNode? = this
      builder.append('[')
      while (next != null) {
        if (builder.length > 1)
          builder.append(", ")
        builder.append(next.`val`)
        next = next.next
      }
      builder.append(']')
      return builder.toString()
    }
  }


  /**
   * Add
   */
  fun s0(l1: ListNode?, l2: ListNode?): ListNode? {
    var sum = l1.add(l2)
    var num = sum % 10
    var carry = sum / 10
    val head = ListNode(num)
    var node = head
    var n1 = l1?.next
    var n2 = l2?.next
    while (n1 !== null || n2 != null || carry != 0) {
      sum = n1.add(n2) + carry
      num = sum % 10
      carry = sum / 10
      node.next = ListNode(num)
      node = node.next as ListNode
      n1 = n1?.next
      n2 = n2?.next
    }
    return head
  }

  private fun ListNode?.add(other: ListNode?): Int {
    return (this?.`val` ?: 0) + (other?.`val` ?: 0)
  }
}