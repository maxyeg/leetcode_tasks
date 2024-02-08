package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes main = new MaxConsecutiveOnes();
        output(main.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0));
        output(main.longestOnes(new int[]{1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1}, 8));
        output(main.longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
        output(main.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        output(main.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int ones = 0;
        int i = 0;
        int max = 0;
        int lastOne = 0;
        int prevlastOne = 0;
        int prev = -1;
        boolean canMove = false;
        while (i < nums.length && zeros <= k) {
            if (nums[i] == 1) {
                ++ones;
                if (prev == 0 && (canMove || (lastOne == prevlastOne && lastOne == 0))) {
                    prevlastOne = lastOne;
                    lastOne = i;
                    canMove = false;
                }
            } else {
                if (k > 0) {
                    if (zeros == k) {
                        max = Math.max(max, ones + zeros);
                        zeros = 0;
                        ones = 0;
                        if (lastOne != prevlastOne) {
                            i = lastOne;
                            canMove = true;
                            prev = -1;
                        }
                        continue;
                    } else {
                        ++zeros;
                    }
                } else {
                    max = Math.max(max, ones + zeros);
                    zeros = 0;
                    ones = 0;
                }
            }
            prev = nums[i];
            i++;
        }
        if (zeros < k && (zeros + ones < nums.length)) {
            i = nums.length - (zeros + ones) - 1;
            while (i >= 0) {
                if (nums[i] == 1) {
                    ++ones;
                } else {
                    if (zeros == k) {
                        break;
                    }
                   ++zeros;
                }
                i--;
            }
        }
        return Math.max(max, ones + zeros);
    }
}
