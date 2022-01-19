package com.hackerrank.basic.data_structures.can_win;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        if (game == null) {
            return false;
        }
        Queue<Integer> traverse = new LinkedList<>(List.of(leap, 1));
        while (!traverse.isEmpty()) {
            int i = traverse.poll();
            if (i >= game.length) {
                return true;
            } else if (i > 0 && game[i] == 0) {
                game[i] = 1;
                traverse.addAll(List.of(i + leap, i + 1, i - 1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
