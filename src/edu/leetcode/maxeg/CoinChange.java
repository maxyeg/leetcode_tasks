package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.Queue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        output(cc.coinChange(new int[]{186,419,83,408}, 6249));
        output(cc.coinChange(new int[]{1,2,5}, 11));
        output(cc.coinChange(new int[]{3,5}, 11));
        output(cc.coinChange(new int[]{2}, 3));
        output(cc.coinChange(new int[]{1}, 0));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(amount);
        visited[amount] = true;
        int currLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int coin : coins) {
                    int child = curr - coin;
                    if (child == 0) {
                        return currLevel;
                    } else {
                        if (child > 0 && !visited[child]) {
                            queue.offer(child);
                            visited[child] = true;
                        }
                    }
                }
            }
            currLevel++;
        }
        return -1;
    }
}
