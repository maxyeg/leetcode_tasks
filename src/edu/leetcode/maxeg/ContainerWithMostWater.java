package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater main = new ContainerWithMostWater();
        output(main.maxArea(new int[]{1,0,0,0,0,0,0,2,2}));
        output(main.maxArea(new int[]{4,8,4,2,4}));
        output(main.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        output(main.maxArea(new int[]{1,1}));
    }
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            if (left == 0) continue;
            int j = i + 1;
            if (max > left) {
                j = max / left + 1;
            }
            for (;j < height.length; j++) {
                int right = height[j];
                max = Math.max(max, (Math.min(left, right) * (j - i)));
            }
        }
        return max;
    }
}
