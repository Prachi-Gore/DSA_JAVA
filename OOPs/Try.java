package com.project;

class Try {
     int totalTires = 4;

    int getTires() {
        return totalTires;
    }

    public static void main(String[] args) {
        Try t = new Try();
        System.out.print(t.getTires());
        System.out.print(t.totalTires);

    }
}
