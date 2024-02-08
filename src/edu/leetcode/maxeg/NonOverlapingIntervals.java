package edu.leetcode.maxeg;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapingIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][] {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}}));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                result++;
            } else {
                end = intervals[i][1];
            }
        }
        return result;
    }

}