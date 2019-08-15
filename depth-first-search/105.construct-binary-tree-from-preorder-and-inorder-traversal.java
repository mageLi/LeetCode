/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (42.40%)
 * Likes:    1931
 * Dislikes: 54
 * Total Accepted:    243.4K
 * Total Submissions: 573.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr) return null;
        if (pl == pr) return new TreeNode(preorder[pl]);
        TreeNode node = new TreeNode(preorder[pl]);
        int pos = 0;
        for (pos = il; pos <= ir; pos++) {
            if (inorder[pos] == preorder[pl]) break;
        }
        int leftLen = pos - il;
        int rightLen = ir - pos;
        node.left = helper(preorder, pl + 1, pl + leftLen, inorder, il, pos - 1);
        node.right = helper(preorder, pl + leftLen + 1, pr, inorder, pos + 1, ir);
        return node;
    }
}

