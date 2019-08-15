import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (34.09%)
 * Likes:    778
 * Dislikes: 125
 * Total Accepted:    120.3K
 * Total Submissions: 352.6K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * 
 * Input: "3+2*2"
 * Output: 7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * 
 * 
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        int res = 0; // Initialization of result
        int sign = 1; // Initialization of sign
        int num = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                if (c == '+' || c == '-') {
                    dq.offerLast()
               } else if (c == '*' || c == '/') {
                    
               }
               num = 0;
            }
        }
    
        return res; // end of expression reached, so demotion happens again
    }
}

