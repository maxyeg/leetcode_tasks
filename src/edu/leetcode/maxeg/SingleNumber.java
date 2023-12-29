package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        output(sn.singleNumber(new int[]{2,2,1}));
        output(sn.singleNumber(new int[]{4,1,2,1,2}));
        output(sn.singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }
}
