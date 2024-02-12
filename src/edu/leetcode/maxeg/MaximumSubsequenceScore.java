package edu.leetcode.maxeg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class MaximumSubsequenceScore {
    public static void main(String[] args) {
        MaximumSubsequenceScore main = new MaximumSubsequenceScore();
        output(main.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
        output(main.maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; i++) {
            ess[i] = new int[] {nums2[i], nums1[i]};
        }
        Arrays.sort(ess, (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS += es[1];
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[0]));
        }
        return res;
    }
}
