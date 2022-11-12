package com.project.Puzzle;

import java.util.Scanner;

public class TowerHanoi {
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        if(disks==1) {
            System.out.println("move 1st disk from "+source+" to "+destination);
            return;
        }
        towerOfHanoi(disks-1,source,destination,auxiliary);
        System.out.println("move " +disks+" th disk from "+source+" to "+destination);
        towerOfHanoi(disks-1,auxiliary,source,destination);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       // int n = s.nextInt();
        towerOfHanoi(3, 'a', 'b', 'c');
    }
}
