import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=879 lang=java
 *
 * [879] Profitable Schemes
 *
 * https://leetcode.com/problems/profitable-schemes/description/
 *
 * algorithms
 * Hard (36.89%)
 * Likes:    159
 * Dislikes: 18
 * Total Accepted:    6K
 * Total Submissions: 16.3K
 * Testcase Example:  '5\n3\n[2,2]\n[2,3]'
 *
 * There are G people in a gang, and a list of various crimes they could
 * commit.
 * 
 * The i-th crime generates a profit[i] and requires group[i] gang members to
 * participate.
 * 
 * If a gang member participates in one crime, that member can't participate in
 * another crime.
 * 
 * Let's call a profitable scheme any subset of these crimes that generates at
 * least P profit, and the total number of gang members participating in that
 * subset of crimes is at most G.
 * 
 * How many schemes can be chosen?  Since the answer may be very large, return
 * it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: G = 5, P = 3, group = [2,2], profit = [2,3]
 * Output: 2
 * Explanation: 
 * To make a profit of at least 3, the gang could either commit crimes 0 and 1,
 * or just crime 1.
 * In total, there are 2 schemes.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 * Output: 7
 * Explanation: 
 * To make a profit of at least 5, the gang could commit any crimes, as long as
 * they commit one.
 * There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and
 * (0,1,2).
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= G <= 100
 * 0 <= P <= 100
 * 1 <= group[i] <= 100
 * 0 <= profit[i] <= 100
 * 1 <= group.length = profit.length <= 100
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution879 {
    Map<String, Integer> map = new HashMap<>();
    int mod = (int)1e9 + 7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        Set<Integer> used = new HashSet<>();
        return dfs(G, P, group, profit, 0, 0, used) % mod;
    }
	private int dfs(int g, int p, int[] group, int[] profit, int val, int num, Set<Integer> used) {
        int res = 0;
        if (num <= g && val >= p) res++;
        if (num > g || used.size() == group.length) return 0;
        String key = val + ":" + num;
        if (map.containsKey(key)) return map.get(key);
        for (int i = 0; i < group.length; i++) {
            if (used.contains(i)) continue;
            used.add(i);
            res += dfs(g, p, group, profit, val + profit[i], num + group[i], used) % mod;
            used.remove(i);
        }
        res %= mod;
        map.put(key, res);
        return res;
	}
}

