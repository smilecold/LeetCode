package xyz.scmile.program.kotlin.leetcode

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
class Q0004 {

  /**
   * Compare each number from head to middle
   * O(n)
   */
  fun s0(nums1: IntArray, nums2: IntArray): Double {
    val len = nums1.size + nums2.size
    var median = 0.0
    val odd = len % 2 == 1
    val determine = if (odd) {
      { i1: Int, i2: Int, mid: Int, value: Int ->
        if (i1 + i2 == mid) {
          median += value.toDouble()
        }
      }
    } else {
      { i1: Int, i2: Int, mid: Int, value: Int ->
        when (i1 + i2) {
          mid, mid - 1 -> median += value
        }
      }
    }
    var i1 = 0
    var i2 = 0
    val mid = len / 2 + 1
    while (i1 + i2 < mid && (i1 < nums1.size || i2 < nums2.size)) {
      val value = when {
        i1 == nums1.size -> nums2[i2++]
        i2 == nums2.size -> nums1[i1++]
        nums1[i1] <= nums2[i2] -> nums1[i1++]
        else -> nums2[i2++]
      }
      determine(i1, i2, mid, value)
    }
    if (!odd) {
      median /= 2
    }
    return median
  }

  /**
   * Shrink median interval
   * O(n)
   */
  fun s1(nums1: IntArray, nums2: IntArray): Double {
    val (n1, n2) = if (nums1.size <= nums2.size) Pair(nums1, nums2) else Pair(nums2, nums1)
    val size = n1.size + n2.size
    val mid = (size + 1) / 2
    var i1 = n1.size / 2
    var i2 = mid - i1
    do {
      val f1 = i1 < n1.size && n1[i1] < n2[i2 - 1]
      val f2 = i1 > 0 && n2[i2] < n1[i1 - 1]
      when {
        f1 -> {
          i1++
          i2--
        }
        f2 -> {
          i1--
          i2++
        }
      }
    } while (f1 || f2)
    return if (size % 2 == 0) {
      (numsCompare(n1, i1 - 1, n2, i2 - 1, Math::max)
          + numsCompare(n1, i1, n2, i2, Math::min)) / 2.0
    } else {
      numsCompare(n1, i1 - 1, n2, i2 - 1, Math::max)
    }
  }

  /**
   * Shrink range by middle
   */
  fun s2(nums1: IntArray, nums2: IntArray): Double {
    val (n1, n2) = if (nums1.size <= nums2.size) Pair(nums1, nums2) else Pair(nums2, nums1)
    val size = n1.size + n2.size
    val mid = (size + 1) / 2
    var min = 0
    var max = n1.size
    while (min <= max) {
      val i1 = (max + min) / 2
      val i2 = mid - i1
      when {
        i1 < n1.size && n1[i1] < n2[i2 - 1] -> min = i1 + 1
        i1 > 0 && n2[i2] < n1[i1 - 1] -> max = i1 - 1
        else ->
          return if (size % 2 == 0) {
            (numsCompare(n1, i1 - 1, n2, i2 - 1, Math::max)
                + numsCompare(n1, i1, n2, i2, Math::min)) / 2.0
          } else {
            numsCompare(n1, i1 - 1, n2, i2 - 1, Math::max)
          }
      }
    }
    return 0.0
  }

  private fun numsCompare(
    array1: IntArray,
    index1: Int,
    array2: IntArray,
    index2: Int,
    compare: (Int, Int) -> Int
  ): Double {
    return when {
      !array1.indices.contains(index1) -> array2[index2].toDouble()
      !array2.indices.contains(index2) -> array1[index1].toDouble()
      else -> compare(array1[index1], array2[index2]).toDouble()
    }
  }
}