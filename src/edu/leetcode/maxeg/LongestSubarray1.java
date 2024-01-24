package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.List;

import static edu.leetcode.maxeg.utils.Utils.output;

public class LongestSubarray1 {
    public static void main(String[] args) {
        LongestSubarray1 ls = new LongestSubarray1();
        output(ls.longestSubarray(new int[]{1,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1}));
        output(ls.longestSubarray(new int[]{1,1,0,1}));
        output(ls.longestSubarray(new int[]{1,1,1}));
        output(ls.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

    public int longestSubarray(int[] nums) {
        List<Integer> list = new LinkedList<>();
        boolean hasZeros = false;
        int max = 0, maxPair = 0, prev = 0, prePrev = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentBit = nums[i];
            if (!hasZeros && currentBit == 0) {
                hasZeros = true;
            }
            int start = i;
            while (i < nums.length && currentBit == nums[i]) {
                i++;
            }
            int currentChain = (i - start) * (currentBit == 1 ? 1 : -1);
            list.add(currentChain);
            if (max > 0 && currentBit == 1 && prev == -1 && prePrev > 0 && prePrev + currentChain > maxPair) {
                maxPair = prePrev + (currentChain);
            }
            if (i - start > max && currentBit == 1) {
                max = currentChain;
            }
            prePrev = prev;
            prev = currentChain;
            --i;
        }
        if (!hasZeros) {
            return nums.length - 1;
        } else {
            return Math.max(max, maxPair);
        }
    }
}
