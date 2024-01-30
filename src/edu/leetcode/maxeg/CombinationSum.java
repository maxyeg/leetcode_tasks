package edu.leetcode.maxeg;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.output;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum main = new CombinationSum();
        output(main.combinationSum3(3, 7));
        output(main.combinationSum3(4, 1));
        output(main.combinationSum3(3, 9));
        output(main.combinationSum3(5, 30));
        output(main.combinationSum3(3, 15));
    }

    private final byte N = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum(k, n, N);
    }

    public List<List<Integer>> combinationSum(int k, int n, int s) {
        if (k > n || n < ((k + 1) * (k / 2)) || n > (k * (N + (N - k + 1))) / 2) return Collections.emptyList();
        List<List<Integer>> result = new LinkedList<>();
        if (k == 1 && n <= s) {
            List<Integer> temp = new LinkedList<>();
            temp.add(n);
            result.add(temp);
            return result;
        }
        int start = s;
        if (n <= s) {
            start = n - k + 1;
        }
        while (start > 0 && (k * (start) * (start - k + 1)) / 2 >= start) {
            List<List<Integer>> a = combinationSum(k - 1, n - start, start - 1);
            for (List<Integer> b : a) {
                if (!b.contains(start) && b.stream().mapToInt(Integer::intValue).sum() + start == n) {
                    b.add(start);
                    result.add(b);
                }
            }
            start--;
        }
        return result;
    }
}
