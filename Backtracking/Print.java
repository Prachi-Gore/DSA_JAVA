package com.project.Backtracking;

public class Print {
    public static void hasPath(int maze[][]){
        int n= maze.length;
        int path[][]=new int[n][n];
        printAllPaths(maze,0,0,path);
    }
    public static void printAllPaths(int maze[][],int i,int j,int path[][]){

        //to check if( i,j ) cell is valid or not
        int n= maze.length;
        if (i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1)//not a valid cell // cell is valid but it is a block cell//it is already part of path
            return ;
        //include the cell in current path
        path[i][j]=1;
        if (i==n-1&&j==n-1) {// rat reach at destination cell
            //print path
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c]+" ");
                }
            }
            System.out.println();//to print all possible paths on different line
            path[i][j]=0;
            return ;
        }
        //Explore further in all direction
        //top
        printAllPaths(maze, i-1, j, path);

        //right
         printAllPaths(maze, i, j+1, path);

        //down
         printAllPaths(maze, i+1, j, path);

        //left
         printAllPaths(maze, i, j-1, path);
         path[i][j]=0;

    }

    public static void main(String[] args) {
       // int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
        int maze[][]= {{1,0,1},{1,1,1},{1,0,1}};

        hasPath(maze);
    }
}
