import java.util.*;
/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (52.41%)
 * Likes:    649
 * Dislikes: 32
 * Total Accepted:    129.2K
 * Total Submissions: 246.4K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * ·
 * All number will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */
class Solution {
    Set<List<Integer>> res;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new HashSet<>();
        this.k = k;
        dfs(n, 0, new ArrayList<>(), 1, new HashSet<>());
        return new ArrayList<>(res);
    }
    private void dfs(int target, int sum, List<Integer> list, int cur, Set<Integer> used) {
        if (sum == target && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || list.size() == k) return;
        for (int i = cur; i < 10; i++) {
            if (used.contains(i)) continue;
            list.add(i);
            used.add(i);
            dfs(target, sum + i, list, i, used);
            list.remove(list.size() - 1);
            used.remove(i);
        }
    }
}

