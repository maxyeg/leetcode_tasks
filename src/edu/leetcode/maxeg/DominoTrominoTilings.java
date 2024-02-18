package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class DominoTrominoTilings {
    public static void main(String[] args) {
        DominoTrominoTilings main = new DominoTrominoTilings();
        output(main.numTilings(5));
        output(main.numTilings(30));
    }

    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        int dp1 = 1, dp2 = 2, dp3 = 5, dp4 = 0, md = ((int) Math.pow(10, 9) + 7);
        for (int i = 4; i <= n; i++) {
            dp4 = ((2 * dp3) % md + dp1) % md;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }
        return dp3;
    }
}
