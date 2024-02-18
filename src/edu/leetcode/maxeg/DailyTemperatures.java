package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        output(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        output(dt.dailyTemperatures(new int[]{30,40,50,60}));
        output(dt.dailyTemperatures(new int[]{30,60,90}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, top = -1;
        int[] ret = new int[n], stack = new int[n];
        for (int i = 0; i < n; i++) {
            while (top > - 1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
