package com.leetcode.binary_tree_bfs._637_average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h1>637. Average of Levels in Binary Tree</h1>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.<br>
 * <br>
 * Example 1:<br>
 * Input: root = [3,9,20,null,null,15,7]<br>
 * Output: [3.00000,14.50000,11.00000]<br>
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.<br>
 * Hence return [3, 14.5, 11].<br>
 * <br>
 * Example 2:<br>
 * Input: root = [3,9,20,15,7]<br>
 * Output: [3.00000,14.50000,11.00000]<br>
 * <br>
 * Constraints:<br>
 * The number of nodes in the tree is in the range [1, 104].<br>
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum / levelSize);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(new Solution().averageOfLevels(root));
    }
}
