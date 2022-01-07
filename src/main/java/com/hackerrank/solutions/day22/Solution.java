package com.hackerrank.solutions.day22;

import java.util.Scanner;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    public static int getHeight(Node root) {
        //Write your code here
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left, 0), getHeight(root.right, 0));
    }

    private static int getHeight(Node root, int currHeight) {
        if (root == null) {
            return currHeight;
        }
        return Math.max(getHeight(root.left, currHeight + 1), getHeight(root.right, currHeight + 1));
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
