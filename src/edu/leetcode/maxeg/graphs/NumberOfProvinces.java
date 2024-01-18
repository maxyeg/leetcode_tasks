package edu.leetcode.maxeg.graphs;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.output;

public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces nop = new NumberOfProvinces();
        output(nop.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
        output(nop.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        output(nop.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited.contains(i)) continue;
            Queue<Integer> nodes = new LinkedList<>();
            provinces++;
            visited.add(i);
            isConnected[i][i] = 0;
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && (!visited.contains(j))) {
                    nodes.add(j);
                }
            }
            if (!nodes.isEmpty()) {
                int tmp = i;
                while (!nodes.isEmpty()) {
                    i = nodes.poll();
                    visited.add(i);
                    isConnected[i][i] = 0;
                    for (int j = 0; j < isConnected[i].length; j++) {
                        if (isConnected[i][j] == 1 && (!visited.contains(j))) {
                            if (!nodes.contains(j)) {
                                nodes.add(j);
                            } else {
                                visited.add(j);
                            }
                        }
                    }
                }
                i = tmp;
            }
        }
        return provinces;
    }
}
