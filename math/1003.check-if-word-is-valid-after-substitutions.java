import java.util.Stack;

/*
 * @lc app=leetcode id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 *
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/description/
 *
 * algorithms
 * Medium (52.31%)
 * Likes:    90
 * Dislikes: 149
 * Total Accepted:    10.7K
 * Total Submissions: 20.4K
 * Testcase Example:  '"aabcbc"'
 *
 * We are given that the string "abc" is valid.
 * 
 * From any valid string V, we may split V into two pieces X and Y such that X
 * + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X
 * + "abc" + Y is also valid.
 * 
 * If for example S = "abc", then examples of valid strings are: "abc",
 * "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are:
 * "abccba", "ab", "cababc", "bac".
 * 
 * Return true if and only if the given string S is valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "aabcbc"
 * Output: true
 * Explanation: 
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" +
 * "abc" + "bc" which is "aabcbc".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcabcababcc"
 * Output: true
 * Explanation: 
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" +
 * "abc" + "c" which is "abcabcababcc".
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "abccba"
 * Output: false
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "cababc"
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 20000
 * S[i] is 'a', 'b', or 'c'
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution1003 {
    /*
     * Solution 2 Brute force using replace will get accepted. Though it's not
     * expected. public boolean isValid(String S) { return helper(S).equals(""); }
     * private String helper(String s) { int index = s.indexOf("abc"); if (index ==
     * -1) return s; s = s.substring(0, index) + s.substring(index + 3, s.length());
     * return helper(s); }
     */
    /*
     * Solution 2 Keep a stack, whenever meet 'c', pop a and b at the end of stack.
     * Otherwise return false.
     */
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b')
                    return false;
                if (stack.isEmpty() || stack.pop() != 'a')
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
