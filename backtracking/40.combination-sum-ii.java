import java.util.*;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (42.77%)
 * Likes:    965
 * Dislikes: 50
 * Total Accepted:    238.1K
 * Total Submissions: 556.7K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution40 {
    /**
     * combination is not  pemutation,
     * 1.first we sort the array
     * 2.dfs
     */
    Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0, new HashSet<>());
        return new ArrayList<>(res);
    }
    private void dfs(int[] candidates, int target, int sum, List<Integer> list, int cur, Set<Integer> used) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;
        for (int i = cur; i < candidates.length; i++) {
            if (used.contains(i)) continue;
            if (i > 0 && candidates[i] == candidates[i - 1] && !used.contains(i - 1)) continue;
            list.add(candidates[i]);
            used.add(i);
            dfs(candidates, target, sum + candidates[i], list, i, used);
            list.remove(list.size() - 1);
            used.remove(i);
        }
    }

}

