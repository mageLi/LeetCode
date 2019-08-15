/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 *
 * https://leetcode.com/problems/frog-jump/description/
 *
 * algorithms
 * Hard (36.68%)
 * Likes:    555
 * Dislikes: 66
 * Total Accepted:    55.6K
 * Total Submissions: 151.5K
 * Testcase Example:  '[0,1,3,4,5,7,9,10,12]'
 *
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but
 * it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * 
 * If the frog's last jump was k units, then its next jump must be either k -
 * 1, k, or k + 1 units. Note that the frog can only jump in the forward
 * direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 2^31.
 * The first stone's position is always 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * 
 * 
 * 
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 * 
 * 
 */
class Solution403 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        if (stones[1] != 1) return false;
        dp[0][1] = true;
        for (int cur = 0; cur < n; cur++) {
            for (int prev = cur - 1; prev >= 0; prev--) {
                if (dp[prev][cur]) {
                    int k = stones[cur] - stones[prev];
                    for (int next = cur + 1; next < n; next++) {
                        int pos = -1;
                        while (pos <= 1) {
                            if (stones[next] == stones[cur] + k + pos) {
                                dp[cur][next] = true;
                                // System.out.println(cur + ":" + next + ":" + k + pos);
                                break;
                            }
                            pos++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i][n - 1]) return true;
        }
        return false;
    }
}

