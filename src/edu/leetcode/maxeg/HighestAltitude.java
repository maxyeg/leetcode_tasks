package edu.leetcode.maxeg;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class HighestAltitude {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
    public static int largestAltitude(int[] gain) {
        int hAlt = 0;
        int curAlt = 0;
        for (int g : gain) {
            curAlt += g;
            hAlt = Math.max(curAlt, hAlt);
        }
        return hAlt;
    }
}