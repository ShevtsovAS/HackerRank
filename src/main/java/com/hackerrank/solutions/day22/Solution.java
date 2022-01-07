package com.hackerrank.solutions.day22;

import java.util.Scanner;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    public int getHeight() {
        if (left == null && right == null) {
            return 0;
        }
        int leftHeight = left == null ? 0 : left.getHeight() + 1;
        int rightHeight = right == null ? 0 : right.getHeight() + 1;
        return Math.max(leftHeight, rightHeight);
    }
}

public class Solution {
    public static int getHeight(Node root) {
        //Write your code here
        return root == null ? 0 : root.getHeight();
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
        int height = getHeight(root);
        System.out.println(height);
    }
}
