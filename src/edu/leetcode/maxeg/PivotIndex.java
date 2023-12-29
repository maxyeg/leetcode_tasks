package edu.leetcode.maxeg;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[] {1,2,3}));
        System.out.println(pivotIndex(new int[] {2,1,-1}));
    }

    public static int pivotIndex(int[] nums) {
        int sumRight = Arrays.stream(nums).sum();
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumRight - nums[i] == sumLeft) return i;
            sumLeft += nums[i];
            sumRight -= nums[i];
        }
        return -1;
    }
}
