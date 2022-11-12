package com.project.Graph;

import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int v=s.nextInt();
        int e=s.nextInt();
        int adjacencyMatrix[][]=new int[v][v];
        for (int i = 0; i < e; i++) {
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            adjacencyMatrix[v1][v2]=weight;
            adjacencyMatrix[v2][v1]=weight;

        }
        dijkstra(adjacencyMatrix);
    }

    private static void dijkstra(int[][] adjacencyMatrix) {
        int v= adjacencyMatrix.length;
        boolean visited[]=new boolean[v];
        int distance[]=new int[v];
        distance[0]=0;//distance of vertex 0 from source 0(itself)is 0
        for (int i = 1; i <v ; i++) {
            distance[i]=Integer.MAX_VALUE;//distance of ith node from source (0)
        }
        for (int i = 0; i <v-1 ; i++) {
            //find vertex with min distance
            int minVertex=findMinVetex(distance,visited);
            visited[minVertex]=true;
            //explore neighbors
            for (int j = 0; j <v ; j++) {
                if (adjacencyMatrix[minVertex][j]!=0&&!visited[j]&&distance[minVertex]!=Integer.MAX_VALUE){
                    int newDist=distance[minVertex]+adjacencyMatrix[minVertex][j];
                    if (newDist<distance[j])
                        distance[j]=newDist;
                }
            }
        }
        //print
        for (int i = 0; i < v; i++) {
            System.out.println(i+" "+distance[i]);

        }

    }

    private static int findMinVetex(int[] distance, boolean[] visited) {
        int minVertex=-1;
        for (int i = 0; i < distance.length ; i++) {
            if (!visited[i]&(minVertex==-1||distance[i]<distance[minVertex]))
                minVertex=i;
        }
        return minVertex;
    }

}
