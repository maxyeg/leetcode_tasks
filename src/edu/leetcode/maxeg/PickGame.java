package edu.leetcode.maxeg;

public class PickGame {
    private static final int g = 1702766719;
    public static void main(String[] args) {
        PickGame pg = new PickGame();
        pg.guessNumber  (2126753390);
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (int) (((long) l + (long) r) / 2);
            int guess = guess(m);
            if (guess == 0) return m;
            if (guess > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    int guess(int num) {
        if (num == g) return 0;
        if (num > g) return -1;
        return 1;
    }
}
