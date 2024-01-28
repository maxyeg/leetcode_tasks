package edu.leetcode.maxeg;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MaxNumberKSumPairs {
    public static void main(String[] args) {
        MaxNumberKSumPairs main = new MaxNumberKSumPairs();
        output(main.maxOperations(new int[]{1,2,3,4}, 5));
        output(main.maxOperations(new int[]{3,1,3,4,3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int result = 0;
        while (start < end) {
            if (nums[start] + nums[end] == k) {
                result++;
                start++;
                end--;
            } else {
                if (nums[start] + nums[end] < k) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
