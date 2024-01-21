package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MinCostClimbStairs {
    public static void main(String[] args) {
        MinCostClimbStairs mccs = new MinCostClimbStairs();
        output(mccs.minCostClimbingStairs(new int[]{10,15,20}));
        output(mccs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] f = new int[cost.length];
        f[0] = cost[0];
        f[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            f[i] = Math.min(f[i - 1], f[i - 2]) + cost[i];
        }
        return Math.min(f[f.length - 1], f[f.length - 2]);
    }
}
