package com.hackerrank.basic.data_structures.comparator.player_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-comparator/problem
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int score = Integer.compare(p2.score, p1.score);
        return score == 0 ? p1.name.compareTo(p2.name) : score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }
}
