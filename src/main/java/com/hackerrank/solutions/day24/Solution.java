package com.hackerrank.solutions.day24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {
    public static Node removeDuplicates(Node head) {
        //Write your code here
        if (head == null) {
            return null;
        }

        Node result = head;

        Set<Integer> existsData = new HashSet<>();
        existsData.add(head.data);
        while (head.next != null) {
            int data = head.next.data;
            if (existsData.contains(data)) {
                head.next = head.next.next;
                continue;
            } else {
                existsData.add(data);
            }
            head = head.next;
        }

        return result;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }
}
