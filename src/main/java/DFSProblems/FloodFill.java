package DFSProblems;

import java.util.Arrays;

public class FloodFill {
    /*
733. Flood Fill
Solved
Easy
Topics
Companies
Hint
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.



Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:



From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.



Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
*/


        public static void dfs(int[][]image, int sr, int sc, int color, boolean[][]vis, int m, int n, int color1){
            if(vis[sr][sc]) return;
            vis[sr][sc]=true;
            if(image[sr][sc]==color1){
                image[sr][sc]=color;
            }else{
                return;
            }


            if(sr+1<m && !vis[sr+1][sc]){
                dfs(image, sr+1, sc, color, vis, m, n, color1);
            }
            if(sr-1>=0 && !vis[sr-1][sc]){
                dfs(image, sr-1, sc, color, vis, m, n, color1);
            }
            if(sc+1<n && !vis[sr][sc+1]){
                dfs(image, sr, sc+1, color, vis, m, n, color1);
            }
            if(sc-1>=0 && !vis[sr][sc-1]){
                dfs(image, sr, sc-1, color, vis, m, n, color1);
            }
        }
        public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int m= image.length;
            int n= image[0].length;
            boolean vis[][]=new boolean[m][n];
            int color1=image[sr][sc];
            dfs(image, sr, sc, color, vis, m, n, color1);
            return image;
        }

    public static void main(String[] args) {
        int[][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][]res= floodFill(image, 1,1,2);
        System.out.print("[ ");
        for (int[] re : res) {
            System.out.print(Arrays.toString(re)+", ");
        }
        System.out.print(" ]");
    }
}
