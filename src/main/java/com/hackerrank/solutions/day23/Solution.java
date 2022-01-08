package com.hackerrank.solutions.day23;

import java.util.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    static void levelOrder(Node root) {
        //Write your code here
        Map<Integer, Queue<Node>> nodeMap = new TreeMap<>();
        levelOrder(nodeMap, root, 0);
        nodeMap.values().forEach(nodes -> nodes.forEach(node -> System.out.printf("%s ", node.data)));
    }

    private static void levelOrder(Map<Integer, Queue<Node>> nodeMap, Node root, int level) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = nodeMap.computeIfAbsent(level, n -> new LinkedList<>());
        queue.add(root);
        levelOrder(nodeMap, root.left, level + 1);
        levelOrder(nodeMap, root.right, level + 1);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
