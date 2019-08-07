/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.68%)
 * Likes:    4030
 * Dislikes: 375
 * Total Accepted:    614.7K
 * Total Submissions: 2.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        int n = s.length();
        int[][] dp = new int[n][n];
        int start = 0;
        int maxLen = 0;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len;
                if (j >= n) continue;
                if (i == j) dp[i][j] = 1;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) dp[i][j] = 2;
                    else if (dp[i + 1][j - 1] != 0) dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = len;
                    start = i;
                }
                // System.out.println("i" + i +  "j" + j + "dp" + dp[i][j]);
            }
        }
        return s.substring(start, start + maxLen + 1);
    }
}

