import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (44.27%)
 * Likes:    1544
 * Dislikes: 1343
 * Total Accepted:    636.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */
class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        Deque<Integer> d = new ArrayDeque<>();
        while (x != 0) {
            d.add(x % 10);
            x /= 10;
        }
        while (!d.isEmpty()) {
            if (d.size() == 1)
                return true;
            if (d.pollFirst() != d.pollLast())
                return false;
        }
        return true;
    }
}
