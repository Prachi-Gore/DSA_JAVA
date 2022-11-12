package com.project.Graph;

import java.util.Arrays;
import java.util.Scanner;

//Kruskal's algorithm
class Edge implements Comparable<Edge>{
    int source;
    int dest;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;//to sort in increasing order
    }
}
public class Kruskal {
    public static void kruskal(Edge [] input,int n) {
        Arrays.sort(input);
        Edge[] output = new Edge[n - 1];
        int parent[] = new int[n];//create parent array
        // initially for each vertex its parent would be that vertex itself
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = 0;
        int i = 0;
        while (count != n - 1) {
            Edge currentEdge = input[i];
            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.dest, parent);
            if (sourceParent != destParent) {//it means there is no cycle
                output[count] = currentEdge;
                count++;
                parent[sourceParent] = destParent;
            }
            i++;
        }

        for (int j = 0; j < n - 1; j++){
            if (output[j].source<output[j].dest)
                System.out.println(output[j].source+" "+output[j].dest+" "+output[j].weight);
            else
                System.out.println(output[j].dest+" "+output[j].source+" "+output[j].weight);

        }
    }

    private static int findParent(int v, int[] parent) {
        if (parent[v]==v)
            return v;
        return findParent(parent[v],parent);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();//number of vertices 0,1,2,..,n-1
        int E=s.nextInt();//number of edges

        Edge[]input=new Edge[E];//each elt of input array is object of class Edge
        for (int i = 0; i <E ; i++) {
            int source = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            Edge edge = new Edge(); //calling edge constructor to create a object of type Edge class
            edge.source = source;
            edge.dest = dest;
            edge.weight = weight;
            input[i] = edge;

        }
        kruskal(input,n);
    }
}
