package xyz.scmile.program.kotlin.leetcode

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 */
class Q0010 {

  /**
   * 如果相同判断下一个是否是*，是转入*继续，完全相同则成功
   * 发现'.'直接匹配成功
   * 发现'*'，判断前一个是否能匹配，可以则判定后面是否能匹配，如果能匹配就匹配后面的，不能就匹配前面的，前面的不能匹配，则转入不同逻辑
   * 如果发现不同，返回上一个'*'，看是否能匹配，不能则跳到上一个'*'，没有则失败，可以就跳到上一个'*'+1
   * 如果到s完了p没完，算作失败
   * 如果p完了，s没完按失败处理
   */
  fun q0(s: String, p: String): Boolean {
    if (p.isEmpty()) return s.isEmpty()
    val m = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')
    return if (p.length >= 2 && p[1] == '*')
      q0(s, p.substring(2)) || m && q1(s.substring(1), p)
    else
      m && q0(s.substring(1), p.substring(1))
  }

  /**
   * 标答
   */
  fun q1(s: String, p: String): Boolean {
    val t = Array(s.length + 1) { Array<Boolean?>(p.length + 1) { null } }
    return qq1(0, 0, s, p, t)
  }

  private fun qq1(
    i: Int,
    j: Int,
    s: String,
    p: String,
    t: Array<Array<Boolean?>>
  ): Boolean {
    if (t[i][j] != null)
      return t[i][j] as Boolean
    if (j == p.length)
      return i == s.length
    val m = i < s.length && (p[j] == s[i] || p[j] == '.')
    return if (j + 1 < p.length && p[j + 1] == '*')
      qq1(i, j + 2, s, p, t) || (m && qq1(i + 1, j, s, p, t))
    else
      m && qq1(i + 1, j + 1, s, p, t)
  }

  fun q2(s: String, p: String): Boolean {
    val dp = Array(
      s.length + 1
    ) { BooleanArray(p.length + 1) }
    dp[s.length][p.length] = true
    for (i in s.length downTo 0) {
      for (j in p.length - 1 downTo 0) {
        val firstMatch = i < s.length &&
            (p[j] == s[i] || p[j] == '.')
        if (j + 1 < p.length && p[j + 1] == '*') {
          dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j]
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1]
        }
      }
    }
    return dp[0][0]
  }
}