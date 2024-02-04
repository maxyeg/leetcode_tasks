package edu.leetcode.maxeg;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.output;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement main = new KthLargestElement();
        output(main.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        output(main.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
