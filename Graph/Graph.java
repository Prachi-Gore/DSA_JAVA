package com.project.Graph;

import java.util.*;

//Implementation
public class Graph {
    //DFS
    public static void printDFS(int edges[][]){
        boolean visited[]=new boolean[edges.length];//jitne vertices hai utne
        for (int i=0;i<visited.length;i++) {//this will help us to print disconnected graph
            if(!visited[i])
            printDFS(edges, i, visited);
        }

    }
    public static void printDFS(int edges[][],int sv,boolean[] visited){
        int n= edges.length;//rows
        System.out.print(sv+" ");
        visited[sv]=true;
        for (int i = 0; i <n ; i++) {
            if (edges[sv][i]==1&!visited[i]) {//if there is edge and not visited previously
                printDFS(edges, i,visited);
            }

        }
    }
    //BFS
    public static void printBFS(int edges[][]){
        boolean visited[]=new boolean[edges.length];//jitne vertices hai utne
        for (int i=0;i<visited.length;i++) {//this will help us to print disconnected graph
            if(!visited[i])
                printBFS(edges, i, visited);
        }
    }
    public static void printBFS(int edges[][],int sv,boolean[] visited){
        int n= edges.length;
        Queue<  Integer>q=new LinkedList();
        q.add(sv)    ;
        visited[sv]=true;
        while (!q.isEmpty()){
               int  front = q.remove();
               System.out.println(front);
            for (int i = 0; i <n ; i++) {
                if (edges[front][i]==1&!visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    //0-1-3 there is path beween 1-3
    public static boolean hasPath(int edges[][],int sv,int ev,boolean [] visited) {//start vertex ev end vertex
        int n = edges.length;
        if (sv > n || ev > n)
            return false;
        if (edges[sv][ev] == 1)
            return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
           int front=q.remove();
            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 &!visited[i]){
                    q.add(i);
                    visited[i]=true;
                }

            }
        }
        if (visited[ev]==true)
            return true;
        else
            return false;
    }
    public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
        if(V1==V2) //if start and end are same add start to the answer and return
        {
            ArrayList<Integer> ans=new ArrayList<>();
            visited[V1]=true;
            ans.add(V1);
            return ans;
        }
        visited[V1]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[V1][i]==1 && !visited[i])
            {   //here we are calling recursion for children of start to end.
                ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2);
                if(arr!=null)
                {
                    arr.add(V1);

                    return arr;
                }
            }
        }
        //if no naswer is found return null
        return null;
    }

    public static ArrayList<Integer> getPathBFS(int[][] edges,boolean[] visited,int V1,int V2){
        //if start and end is same just ass v1 to answrer arraylist and return it.
        if(V1==V2)
        {
            ArrayList<Integer> ans=new ArrayList<Integer>();
            ans.add(V1);
            visited[V1]=true;
            return ans;
        }
        Queue<Integer> q=new LinkedList<Integer>(); //q for all vertices of graphs
        HashMap<Integer,Integer> h=new HashMap<>(); //<dest,src> intger hashmap to know which the source and destination vertex
        ArrayList<Integer> ans=new ArrayList<>(); // answer arraylist to store the answer
        q.add(V1); //add the source to the queue
        visited[V1]=true; //mark visited as true
        while(!q.isEmpty() ){
            int first=q.remove();
            for(int i=0;i<edges.length;i++){
                if(edges[first][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.add(i);
                    h.put(i,first); //here we are connecting the start and destination vertex//i:destination first:source
                    if(i==V2)
                    {    ans.add(i);  //if end vertex matches i put it in arraylist output
                        while(!ans.contains(V1)){ //now we loop throgh hashmap until we reach the source

                            int b=h.get(i); //give the parent of i
                            ans.add(b); //add the parent(source) to arraylist
                            i=b; //update i to b// through this we are moving upwards from down
                        }
                        return ans;
                    }
                }
            }
        }
        //if no route is found return null
        return null;
    }
    public static boolean isConnected(int[][] edges,int sv) {//sv=0
        boolean[] visited = new boolean[edges.length];// size of visited array=no.of vertices
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            for(int i=0;i<edges.length;i++) {
                if(!visited[i] && edges[front][i] ==1) {
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        //now loop through visited array if you have any not visited vertex( that is false value )means graph is not connected
        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }
        //if all values are true, means graph is connected
        return true;
    }
    public static void ConnectedComponents(int edges[][],boolean visited[],ArrayList<Integer> arr,int start){
        //here we are using DFS, that is recursion
        visited[start]=true;
        arr.add(start);
        int n=edges.length;
        for(int j=0;j<n;j++){
            if(edges[start][j]==1&&!visited[j]){
                ConnectedComponents(edges,visited,arr,j);
            }
        }



    }
    public static ArrayList<ArrayList<Integer>> ConnectedComponents(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                // this array list is creating again and again

                ArrayList<Integer> arr = new ArrayList<Integer>();
                ConnectedComponents(edges, visited, arr, i); //here we get a connected graph starting from i
                Collections.sort(arr); //here we are sorting the values in the arraylist by using collections
                ans.add(arr);//store sorted array in final ans
            }
        }
        return ans;
    }











    public static void main(String[] args) {
//        int n;//number of vertices
//       int e;//number of edges
//        Scanner s=new Scanner(System.in) ;
//        n=s.nextInt();
//        e=s.nextInt();
//        int edges[][]=new int[n][n];//0 to n-1
//        for (int i = 0; i <e ; i++) { //0th edge 1st edge ,...upto (e-1)th edge
//            //for each edge there will be 2 vertices
//            int fv=s.nextInt();
//            int sv=s.nextInt();
//            edges[fv][sv]=1;//edge between first vertex and second vertex
//            edges[sv][fv]=1;//edge between second vertex and first vertex

 //       printDFS( new int[][]{{0,1,1,0,0},{1,0,1,0,0},{1,1,0,0,0},{0,0,0,0,1},{0,0,0,1,0}});
  //      System.out.println(isConnected(new int[][]{{0,1,1},{1,0,1},{1,1,0}},0));
       ArrayList<ArrayList<Integer>> ans= ConnectedComponents(new int[][]{{0,1,1,0,0},{1,0,1,0,0},{1,1,0,0,0},{0,0,0,0,1},{0,0,0,1,0}}) ;
        for (int i = 0; i < ans.size() ; i++) {
            for (int j = 0; j <ans.get(i).size() ; j++) {
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    }



