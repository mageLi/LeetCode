/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (48.04%)
 * Likes:    1454
 * Dislikes: 45
 * Total Accepted:    68.6K
 * Total Submissions: 142.8K
 * Testcase Example:  '[3,1,5,8]'
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * Example:
 * 
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  -->
 * []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 */
class Solution312 {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        int index = 1;
        dp = new int[n][n];
        newNums[0] = newNums[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[index++] = nums[i];
        }
        dfs(newNums, 0, n - 1);
        return dp[0][n - 1];
    }
    private int dfs(int[] nums, int l, int r) {
        if (l + 1 == r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        int max = 0;
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max, nums[l] * nums[i] * nums[r] + dfs(nums, l, i) + dfs(nums, i, r));
        }
        dp[l][r] = max;
        return max;
    }
}

