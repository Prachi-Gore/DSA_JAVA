package com.project.Backtracking;

public class RatInAMaze {
    public static boolean hasPath(int maze[][]){
        int n= maze.length;
        int path[][]=new int[n][n];
        return solveMaze(maze,0,0,path);
    }
    public static boolean solveMaze(int maze[][],int i,int j,int path[][]){
        //solve maze give us ans whether path exist or not through/at (i,j)th cell
        //to check if( i,j ) cell is valid or not
        int n= maze.length;
        if (i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1)//not a valid cell // cell is valid but it is a block cell//it is already part of path
            return false;
        //include the cell in current path
        path[i][j]=1;
        if (i==n-1&&j==n-1) {// rat reach at destination cell
            //print path
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c]+" ");
                }
                System.out.println();
            }
            return true;
        }
        //Explore further in all direction
        //top
       if( solveMaze(maze, i-1, j, path))
           return true;
       //right
        if( solveMaze(maze, i, j+1, path))
            return true;
        //down
        if( solveMaze(maze, i+1, j, path))
            return true;
        //left
        if( solveMaze(maze, i, j-1, path))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
       // int maze[][]= {{1,1,0},{1,1,0},{1,1,0}};
        System.out.println(hasPath(maze));


    }
}
