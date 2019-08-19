package xyz.scmile.program.kotlin.leetcode

import java.security.InvalidParameterException

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
class Q0001 {

  /**
   * Traversing
   */
  fun s0(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size - 1) {
      for (j in i + 1 until nums.size) {
        if (nums[i] + nums[j] == target) {
          return intArrayOf(i, j)
        }
      }
    }
    throw InvalidParameterException("Can not found eligible number ${nums.toList()} $target")
  }

  /**
   * Use hash map
   */
  fun s1(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for ((i, num) in nums.withIndex()) {
      val value = map[num]
      if (value == null) {
        map[target - num] = i
      } else {
        return intArrayOf(value, i)
      }
    }
    return intArrayOf(0, 0)
  }
}