package edu.leetcode.maxeg;

import java.util.HashMap;
import java.util.Map;

import static edu.leetcode.maxeg.utils.Utils.output;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        EqualRowAndColumnPairs main = new EqualRowAndColumnPairs();
        output(main.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        output(main.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        output(main.equalPairs(new int[][]{{3,1,2,2},{1,4,4,4},{2,4,2,2},{2,5,2,2}}));
    }
    public int equalPairs(int[][] grid) {
        Map<Long, Integer> rowsHashes = new HashMap<>();
        Map<Long, Integer> colsHashes = new HashMap<>();
        final int num = 17;
        for (int i = 0; i < grid.length; i++) {
            long rowHash = (long) Math.pow(num, 0), colHash = rowHash;
            for (int j = 0; j < grid.length; j++) {
                long base = (long) Math.pow(num, j);
                rowHash += base * grid[i][j];
                colHash += base * grid[j][i];
            }
            rowsHashes.put(rowHash, rowsHashes.getOrDefault(rowHash, 0) + 1);
            colsHashes.put(colHash, colsHashes.getOrDefault(colHash, 0) + 1);
        }
        int result = 0;
        for (Long hash : rowsHashes.keySet()) {
            if (colsHashes.containsKey(hash)) {
                result += colsHashes.get(hash) * rowsHashes.get(hash);
            }
        }
        return result;
    }
}
