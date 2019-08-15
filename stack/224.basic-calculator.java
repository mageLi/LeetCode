import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (33.46%)
 * Likes:    848
 * Dislikes: 98
 * Total Accepted:    116.3K
 * Total Submissions: 347.3K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * Example 1:
 * 
 * 
 * Input: "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * 
 * 1 + 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    int i = 0;
    int num = 0;
    int sign = 1;
    public int calculate(String s) {
        // "(1+(4+5+2)-3)+(6+8)"
        int res = 0;
        while (i < s.length()) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
            // System.out.println(i + ":" + j);
            num = Integer.parseInt(s.substring(i, j));
            res += sign * num;
            num = 0;
            i = j;
        } else if (c == '(') {
            int j = i + 1;
            int count = 1;
            while (j < s.length() && s.charAt(j) != ')' && count != 0) {
                if (s.charAt(j) == '(') count++;
                if (s.charAt(j) == ')') count--;
                j++;
            }
            res += sign * calculate(s.substring(i + 1, j));
            i = j + 1;
        } else if (c == '-' || c == '+') {
            sign = c == '+' ? 1 : -1;
            i++;
        } else i++;
        // System.out.println(i);
    }
        return res;
    }
}


 