import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 *
 * https://leetcode.com/problems/mini-parser/description/
 *
 * algorithms
 * Medium (32.16%)
 * Likes:    179
 * Dislikes: 625
 * Total Accepted:    31.3K
 * Total Submissions: 97.1K
 * Testcase Example:  '"324"'
 *
 * Given a nested list of integers represented as a string, implement a parser
 * to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Note:
 * You may assume that the string is well-formed:
 * 
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * 
 * 

the add() method adds a NestedInteger object to the caller. e.g.:
outer = NestedInteger() # []
nested = NestedInteger(5)
outer2 = nested
outer.add(nested) # outer is now [5]
outer2.add(outer) # outer2 is now [5, [5]]
"Set this NestedInteger to hold a nested list and adds a nested integer elem to it." cannot be more vague.

'-' means negative. It's not a delimiter.

For test cases like "324" you need to return something like NestedInteger(324) not "[324]".

A list cannot have multiple consecutive integers. e.g. "321, 231" is invalid. I guess it's for difficulty purposes.
 * 
 * 
 * Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer
 * 324.
 * 
 * 
 * 
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * ⁠   i.  An integer containing value 456.
 * ⁠   ii. A nested list with one element:
 * ⁠        a. An integer containing value 789.
 * 
 * 
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    /* 
    This approach will just iterate through every char in the string (no recursion).
    If encounters '[', push current NestedInteger to stack and start a new one.
    If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
    If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
    Update index l and r, where l shall point to the start of a integer substring, 
    while r shall points to the end+1 of substring.
    */
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> dq = new ArrayDeque<>();
        int i = 0;
        NestedInteger res = new NestedInteger();
        NestedInteger cur = new NestedInteger();
        while (i < s.length() {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (int)(s.charAt(i++) - '0');
                }
            } else if (c == ',') {
                NestedInteger temp = new NestedInteger(num);
                num = 0;
                dq.offerLast(temp);
            } else if (c == '[') {
                dq.offerLast(num);
                num = new NestedInteger();
            } else if (c == ']') {
                num = dq.pollLast();
            }
        }
    }
}

