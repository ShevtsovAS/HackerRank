package com.leetcode.binary_search_tree._530_minimum_absolute_difference_in_BST;

/**
 * <h1>530. Minimum Absolute Difference in BST</h1>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.<br>
 * <br>
 * Example 1:<br>
 * Input: root = [4,2,6,1,3]<br>
 * Output: 1<br>
 * <br>
 * Example 2:<br>
 * Input: root = [1,0,48,null,null,12,49]<br>
 * Output: 1<br>
 * <br>
 * Constraints:<br>
 * The number of nodes in the tree is in the range [2, 10^4].<br>
 * 0 <= Node.val <= 10^5<br>
 * <br>
 * Note: This question is the same as 783: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">minimum-distance-between-bst-nodes</a>
 */
public class Solution {
    private Integer prev;

    public int getMinimumDifference(TreeNode root) {
        return inOrderTraversal(root, Integer.MAX_VALUE);
    }

    private int inOrderTraversal(TreeNode node, int min) {
        if (node == null) return min;
        min = inOrderTraversal(node.left, min);
        if (prev != null) min = Math.min(min, node.val - prev);
        prev = node.val;
        return inOrderTraversal(node.right, min);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4)
                ),
                new TreeNode(7));
        System.out.println(new Solution().getMinimumDifference(root));
    }
}
