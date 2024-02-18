package edu.leetcode.maxeg;

import java.util.PriorityQueue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class HireKWorkers {
    public static void main(String[] args) {
        HireKWorkers main = new HireKWorkers();
        output(main.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        output(main.totalCost(new int[]{1,2,4,1}, 3, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0, j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }
            int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
            if (t1 <= t2) {
                ans += t1;
                pq1.poll();
            } else {
                ans += t2;
                pq2.poll();
            }
        }
        return ans;
    }
}
