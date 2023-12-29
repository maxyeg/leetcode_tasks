package edu.leetcode.maxeg;

import java.util.Arrays;

public class CountingBit {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(7)));
    }

    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
