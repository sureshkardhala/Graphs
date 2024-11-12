package BFSProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    /*
994. Rotting Oranges
Solved
Medium
Topics
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

        public static int orangesRotting(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int vis[][] = new int[m][n];
            Queue<int[]> queue = new LinkedList<>();
            int unRottedOranges=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    vis[i][j]=grid[i][j];
                    if(grid[i][j]==2){
                        queue.add(new int[]{i,j});
                    }
                    if(grid[i][j]==1){
                        unRottedOranges++;
                    }
                }
            }
            if(unRottedOranges==0) return 0;
            int timeCount=0;
            while(!queue.isEmpty()){
                int size=queue.size();
                timeCount++;
                for(int k=0; k<size; k++){
                    int[] poll = queue.poll();
                    int i=poll[0];
                    int j=poll[1];
                    if(i+1<m && vis[i+1][j]==1){
                        queue.add(new int[]{i+1, j});
                        vis[i+1][j]=2;
                        unRottedOranges--;
                    }
                    if(i-1>=0 && vis[i-1][j]==1){
                        queue.add(new int[]{i-1, j});
                        vis[i-1][j]=2;
                        unRottedOranges--;
                    }
                    if(j+1<n && vis[i][j+1]==1){
                        queue.add(new int[]{i, j+1});
                        vis[i][j+1]=2;
                        unRottedOranges--;
                    }
                    if(j-1>=0 && vis[i][j-1]==1){
                        queue.add(new int[]{i, j-1});
                        vis[i][j-1]=2;
                        unRottedOranges--;
                    }
                }
            }

            if(unRottedOranges!=0) return -1;
            return timeCount-1;
        }

    public static void main(String[] args) {
//        int[][]grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][]grid= {{0,2}};
        int res= orangesRotting(grid);
        System.out.println(res);
    }
}
