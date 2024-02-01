package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MinimumFlips {
    public static void main(String[] args) {
        MinimumFlips main = new MinimumFlips();
        output(main.minFlips(5,2,8));
        output(main.minFlips(8,3,5));
        output(main.minFlips(2,6,5));
        output(main.minFlips(4,2,7));
        output(main.minFlips(1,2,3));
    }

    public int minFlips(int a, int b, int c) {
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        String sc = Integer.toBinaryString(c);
        int l = Math.max(sc.length(), Math.max(sa.length(), sb.length()));
        if (sb.length() < l) {
            sb = String.format("%0" + (l - sb.length()) + "d%s", 0, sb);
        }
        if (sa.length() < l) {
            sa = String.format("%0" + (l - sa.length()) + "d%s", 0, sa);
        }
        if (sc.length() < l) {
            sc = String.format("%0" + (l - sc.length()) + "d%s", 0, sc);
        }
        int flips = 0;
        for (int i = 0; i < l; i++) {
            // 0 OR 0 = 0
            // 1 OR 1 = 1
            // 1 OR 0 = 1
            // 0 OR 1 = 1
            char ca = sa.charAt(i);
            char cb = sb.charAt(i);
            char cc = sc.charAt(i);
            if ((ca | cb) != cc) {
                if (cc == '0') {
                    if (ca == '1') flips++;
                    if (cb == '1') flips++;
                } else {
                    if (ca == '0' && cb == '0') {
                        flips++;
                    }
                }
            }
        }
        return flips;
    }
}
