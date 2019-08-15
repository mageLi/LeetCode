import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 *
 * algorithms
 * Medium (28.36%)
 * Likes:    573
 * Dislikes: 40
 * Total Accepted:    12.9K
 * Total Submissions: 45K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2],
 * [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * 
 * 
 * 
 * 
 * 
 * 
 */

 /* 
 
Hash map freq will count the frequence of elements.
Hash map m is a map of stack.
If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]
maxfreq records the maximum frequence.

push(x) will push x tom[++freq[x]]
pop() will pop from the m[maxfreq]
 */
class Solution907 {
    public int sumSubarrayMins(int[] A) {
        int res = 0;
        int n = A.length;
        int mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // find the first element less than A[i]
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // find the first element less or equal A[i]
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(left[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(right[i] + ",");
        }
        for (int i = 0; i < n; i++) {
            res += (right[i] - i) % mod * A[i] * (i - left[i]) % mod;
            res %= mod;
        }
        return res % mod;
    }
}

