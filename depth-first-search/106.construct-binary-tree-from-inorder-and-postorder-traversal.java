/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.39%)
 * Likes:    967
 * Dislikes: 20
 * Total Accepted:    163.8K
 * Total Submissions: 405.1K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr) return null;
        if (pl == pr) return new TreeNode(postorder[pr]);
        TreeNode node = new TreeNode(postorder[pr]);
        int pos = 0;
        for (pos = il; pos <= ir; pos++) {
            if (inorder[pos] == postorder[pr]) break;
        }
        int leftLen = pos - il;
        int rightLen = ir - pos;
        node.left = helper(postorder, pl, pl + leftLen - 1, inorder, il, pos - 1);
        node.right = helper(postorder, pr - rightLen, pr - 1, inorder, pos + 1, ir);
        return node;
    }
}

