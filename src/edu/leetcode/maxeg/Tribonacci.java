package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class Tribonacci {
    public static void main(String[] args) {
        Tribonacci t = new Tribonacci();
        output(t.tribonacci(4));
        output(t.tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = next;
        }
        return t2;
    }
}
