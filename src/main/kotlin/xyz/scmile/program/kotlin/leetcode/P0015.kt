package xyz.scmile.program.kotlin.leetcode

/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
class P0015 {

  /**
   * Traversing
   * time out
   */
  fun s0(nums: IntArray): List<List<Int>> {
    nums.sort()
    val list = ArrayList<List<Int>>()
    for (i in 0 until nums.size - 2)
      for (j in i + 1 until nums.size - 1)
        for (k in j + 1 until nums.size) {
          val value = nums[i] + nums[j] + nums[k]
          if (value == 0) {
            val listInt = listOf(nums[i], nums[j], nums[k])
            if (!list.contains(listInt))
              list.add(listInt)
          }
        }
    return list
  }

  /**
   * Move location of sorted method
   * O(n^3)
   */
  fun s1(nums: IntArray): List<List<Int>> {
    val list = ArrayList<List<Int>>()
    for (i in 0 until nums.size - 2)
      for (j in i + 1 until nums.size - 1)
        for (k in j + 1 until nums.size) {
          val value = nums[i] + nums[j] + nums[k]
          if (value == 0) {
            val listInt = listOf(nums[i], nums[j], nums[k]).sorted()
            if (!list.contains(listInt))
              list.add(listInt)
          }
        }
    return list
  }

  /**
   * Use p0001
   * O(n^2)
   */
  fun s2(nums: IntArray): List<List<Int>> {
    val result = HashSet<List<Int>>()
    for ((i, num) in nums.withIndex()) {
      val map = HashMap<Int, Int>()
      for (j in i + 1 until nums.size) {
        val value = map[nums[j]]
        if (value == null) {
          map[0 - num - nums[j]] = j
        } else {
          val list = listOf(num, nums[j], nums[value]).sorted()
          if (!result.contains(list)) {
            result.add(list)
          }
        }
      }
    }
    return result.toList()
  }

  /**
   * Copied
   */
  fun s3(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = HashSet<List<Int>>()
    for (i in 1 until nums.size - 1) {
      var first = 0
      var last = nums.size - 1
      loop@ while (true) {
        val value = nums[first] + nums[i] + nums[last]
        if (value == 0) {
          val list = listOf(nums[first], nums[i], nums[last])
          if (!result.contains(list))
            result.add(list)
        }
        when {
          value <= 0 -> {
            while (nums[first] == nums[++first]) {
              if (first >= i) {
                break@loop
              }
            }
            if (first >= i) {
              break@loop
            }
          }
          else -> {
            while (nums[last] == nums[--last]) {
              if (last <= i) {
                break@loop
              }
            }
            if (last <= i) {
              break@loop
            }
          }
        }
      }
    }
    return result.toList()
  }

  /**
   * Use i as the lower limit
   */
  fun s4(nums: IntArray): List<List<Int>> {
    val sorted = nums.sorted()
    if (sorted.size < 3 || sorted[0] > 0 || sorted[sorted.size - 1] < 0) {
      return emptyList()
    }
    val list = ArrayList<List<Int>>()
    for (l in 0 until sorted.size - 2) {
      if (sorted[l] > 0) {
        break
      }
      if (l > 0 && sorted[l] == sorted[l - 1]) {
        continue
      }
      var m = l + 1
      var r = sorted.size - 1
      loop@ while (m < r) {
        val value = sorted[l] + sorted[m] + sorted[r]
        if (value == 0) {
          list.add(listOf(sorted[l], sorted[m], sorted[r]))
        }
        when {
          value <= 0 -> {
            while (sorted[m] == sorted[++m]) {
              if (m >= r) {
                break@loop
              }
            }
          }
          else -> {
            while (sorted[r] == sorted[--r]) {
              if (m >= r) {
                break@loop
              }
            }
          }
        }
      }
    }
    return list
  }
}