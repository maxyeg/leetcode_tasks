package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GreeatestNumberOfCandies {

    public static void main(String[] args) {
        kidsWithCandies(new int[]{2,3,5,1,3}, 3);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            if (i > max) max = i;
        }
        List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}