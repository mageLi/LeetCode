import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (49.87%)
 * Likes:    2238
 * Dislikes: 70
 * Total Accepted:    373.1K
 * Total Submissions: 748.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution39 {
    /**
     * combination is not  pemutation,
     * 1.first we sort the array
     * 2.dfs
     */
    Set<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    private void dfs(int[] candidates, int target, int sum, List<Integer> list, int cur) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;
        for (int i = cur; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }

}

