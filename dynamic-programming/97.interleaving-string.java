/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (28.56%)
 * Likes:    856
 * Dislikes: 48
 * Total Accepted:    118.1K
 * Total Submissions: 413.3K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
 * s2.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 */
class Solution {
    boolean[][] dp;
    int m, n, end;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        end = s3.length();
        if (m + n != end) return false;
        dp = new boolean[m + 1][n + 1];
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }
    private boolean dfs(char[] a, char[] b, char[] c, int i, int j, int k) {
        if (dp[i][j]) return false;
        if (k == end) return true;
        boolean vaild = (i < m && a[i] == c[k] && dfs(a, b, c, i + 1, j, k + 1)) ||
        (j < n && b[j] == c[k] && dfs(a,b,c,i, j+ 1, k + 1));
        if (!vaild) dp[i][j] = true; 
        return vaild;
    }
}

