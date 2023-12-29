package edu.leetcode.maxeg;

public class ClimbStairsEasy {

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        //4 = 1 + 1 + 1 + 1; 1 + 1 + 2; 1 + 2 + 1; 2 + 1 + 1; 2 + 2;
        /*
        F(1) = 1; F(2) = 2; F(3) = 3; F(4) = 5; F(N) = F(N-1) + F(N-2)
         */
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] fibs = new int[45];
        fibs[0] = 1;
        fibs[1] = 2;
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[n-1];
    }
}
