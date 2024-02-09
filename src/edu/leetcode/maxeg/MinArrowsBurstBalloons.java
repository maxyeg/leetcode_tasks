package edu.leetcode.maxeg;

import java.util.Arrays;
import java.util.Comparator;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MinArrowsBurstBalloons {
    public static void main(String[] args) {
        MinArrowsBurstBalloons main = new MinArrowsBurstBalloons();
        output(main.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        output(main.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        output(main.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                result++;
            } else {
                end = points[i][1];
            }
        }
        return points.length - result;
    }
}
