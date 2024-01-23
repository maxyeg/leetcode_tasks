package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        output(ro.orangesRotting(new int[][]{{2,1,1},{1,1,1},{0,1,2}}));
        output(ro.orangesRotting(new int[][]{{0,2}}));
        output(ro.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        output(ro.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        // Add points with initially rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minutes = 0;
        int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        while (!q.isEmpty() && fresh > 0) {
            minutes++;
            int n = q.size();
            //make adjacent rotten
            for (int i = 0; i < n; i++) {
                int[] point = q.poll();
                //add to queue in all directions & mark rotten
                for (int j = 0; j < directions.length; j++) {
                    int x = point[0] + directions[j][0];
                    int y = point[1] + directions[j][1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                    fresh--;
                }
            }
        }
        //compare rotten num with N x M
        if (fresh == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}
