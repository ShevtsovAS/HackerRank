package com.leetcode.binary_tree_general._104_maximum_depth_of_binary_tree;

/**
 * <h1>104. Maximum Depth of Binary Tree</h1>
 * Given the root of a binary tree, return its maximum depth.<br>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.<br>
 * <br>
 * Example 1:<br>
 * <br>
 * Input: root = [3,9,20,null,null,15,7]<br>
 * Output: 3<br>
 * <br>
 * Example 2:<br>
 * Input: root = [1,null,2]<br>
 * Output: 2<br>
 * <br>
 * Constraints:<br>
 * The number of nodes in the tree is in the range [0, 10^4].<br>
 * -100 <= Node.val <= 100<br>
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(new Solution().maxDepth(root));
    }
}
