import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.42%)
 * Likes:    2336
 * Dislikes: 3586
 * Total Accepted:    757.5K
 * Total Submissions: 3M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */
class Solution7 {
    public int reverse(int x) {
        boolean flag = false;
        if (x == Integer.MIN_VALUE)
            return 0;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        Queue<Integer> q = new LinkedList<>();
        while (x != 0) {
            q.offer(x % 10);
            x /= 10;
        }
        long res = 0;
        while (!q.isEmpty()) {
            res = res * 10 + q.poll();
            if (res > Integer.MAX_VALUE)
                return 0;
        }

        return flag ? (int) -res : (int) res;
    }
}
