package edu.leetcode.maxeg;

import java.util.Arrays;
import java.util.Comparator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class NonOverlapingIntervals {

    public static void main(String[] args) {
//        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
//        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
//        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}}));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int result = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (overlap(intervals[i], intervals[i + 1])) {
                ++result;
                if (intervals[i+1][1]-intervals[i+1][0] > intervals[i][1]-intervals[i][0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[i + 1];
                    intervals[i + 1] = tmp;
                }
            }
        }
        return result;
    }

    private static boolean overlap(int[] a, int[] b) {
        if (a[0] <= b[0]) {
            return a[1] > b[0];
        } else return b[1] > a[0];
    }
}