import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.67%)
 * Likes:    1546
 * Dislikes: 1791
 * Total Accepted:    280.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution91 {
    /* 
    dfs + memo
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return helper(s, 0);
    }
    private int helper(String s, int pos) {
        if (map.containsKey(pos)) return map.get(pos);
        if (pos == s.length()) return 1;
        int res = 0;
        if (pos + 1 <= s.length() && Integer.parseInt(s.substring(pos, pos + 1)) > 0) {
            res += helper(s, pos + 1);
        }
        if (pos + 2 <= s.length() && Integer.parseInt(s.substring(pos, pos + 2)) <= 26 && Integer.parseInt(s.substring(pos, pos + 2)) >= 10) {
            res += helper(s, pos + 2);
        }
        // System.out.println(pos + ":" + res);
        map.put(pos, res);
        return res;
    }
    */

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') return 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0) dp[i] += dp[i - 1];
            if (second <= 26 && second >= 10) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}

