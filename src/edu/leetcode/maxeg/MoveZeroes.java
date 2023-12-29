package edu.leetcode.maxeg;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{1});
    }
    public static void moveZeroes(int[] nums) {
        int zerosCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosCnt++;
            } else if (zerosCnt != 0) {
                nums[i - zerosCnt] = nums[i];
                nums[i] = 0;
            }
        }
    }
}