package edu.leetcode.maxeg.graphs;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.output;

public class ReorderRoutes {
    public static void main(String[] args) {
        ReorderRoutes rr = new ReorderRoutes();
        output(rr.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
        output(rr.minReorder(5, new int[][]{{1,0},{1,2},{3,2},{3,4}}));
        output(rr.minReorder(3, new int[][]{{1,0},{2,0}}));
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> fromRoutes = new HashMap<>(), toRoutes = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            List<Integer> list = fromRoutes.get(from);
            if (list == null) list = new LinkedList<>();
            list.add(to);
            fromRoutes.put(from, list);
            list = toRoutes.get(to);
            if (list == null) list = new LinkedList<>();
            list.add(from);
            toRoutes.put(to, list);
        }
        return dfs(0, new HashSet<>(), fromRoutes, toRoutes);
    }

    private int dfs(int node, Set<Integer> visited, Map<Integer,
            List<Integer>> inRoutes, Map<Integer, List<Integer>> outRoutes) {
        if (!visited.contains(node)) {
            visited.add(node);
            List<Integer> toNodes = inRoutes.get(node);
            int result = 0;
            if (toNodes != null) {
                for (int i : toNodes) {
                    if (!visited.contains(i)) {
                        result++;
                        result += dfs(i, visited, inRoutes, outRoutes);
                    }
                }
            }
            List<Integer> fromNodes = outRoutes.get(node);
            if (fromNodes != null) {
                for (int i : fromNodes) {
                    result += dfs(i, visited, inRoutes, outRoutes);
                }
            }
            return result;
        } else {
            return 0;
        }
    }
}
