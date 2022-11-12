package com.project.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class Island {
    public static void ConnectedIsland(int adjacencyMatrix[][], boolean visited[], int start){
        //here we are using DFS, that is recursion
        visited[start]=true;
       // arr.add(start);
        int n=adjacencyMatrix.length;
        for(int j=0;j<n;j++){
            if(adjacencyMatrix[start][j]==1&&!visited[j]){
                ConnectedIsland(adjacencyMatrix,visited,j);
            }
        }



    }
    public static int ConnectedIsland(int edges[][]) {
        int count=0;
        boolean visited[] = new boolean[edges.length];
       // ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                count++;
                // this array list is creating again and again

               // ArrayList<Integer> arr = new ArrayList<Integer>();
                ConnectedIsland(edges, visited, i); //here we get a connected graph starting from i
              //  Collections.sort(arr); //here we are sorting the values in the arraylist by using collections
               // ans.add(arr);//store sorted array in final ans
            }
        }
        return count;
    }
}
