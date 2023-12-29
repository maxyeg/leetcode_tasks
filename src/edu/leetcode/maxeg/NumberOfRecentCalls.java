package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    public static void main(String[] args) {
        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();
        numberOfRecentCalls.run();
    }

    public void run() {
        RecentCounter rc = new RecentCounter();
        rc.ping(1);
        rc.ping(100);
        rc.ping(3001);
        rc.ping(3002);
    }

    class RecentCounter {

        public static int INTERVAL = 3000;

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            do {
                if (t - INTERVAL > queue.peek()) queue.poll();
            } while (queue.peek() + INTERVAL < t);
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

}
