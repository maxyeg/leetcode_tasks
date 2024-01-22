package edu.leetcode.maxeg.graphs;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.output;

public class NearestExitFromMaze {
    public static void main(String[] args) {
        NearestExitFromMaze maze = new NearestExitFromMaze();
        output(maze.nearestExit(new char[][]{
                {'+', '.', '+', '.', '.', '+', '.', '.', '+', '.', '.', '.', '+', '+', '.', '.', '.', '.', '+', '.'},
                {'.', '+', '+', '.', '+', '.', '.', '.', '+', '+', '+', '.', '+', '.', '.', '+', '.', '+', '+', '.'},
                {'+', '.', '.', '.', '.', '+', '.', '.', '.', '.', '.', '.', '.', '.', '+', '.', '.', '+', '+', '.'},
                {'.', '.', '.', '+', '+', '.', '.', '.', '+', '.', '+', '.', '.', '+', '.', '.', '+', '.', '.', '.'},
                {'+', '.', '.', '.', '.', '.', '+', '.', '.', '+', '.', '.', '+', '+', '.', '+', '+', '.', '.', '.'},
                {'.', '+', '.', '.', '.', '.', '+', '.', '+', '.', '.', '.', '.', '.', '.', '+', '.', '+', '+', '+'},
                {'.', '.', '.', '+', '.', '.', '+', '.', '+', '+', '.', '+', '.', '.', '.', '.', '.', '+', '.', '.'},
                {'.', '.', '.', '.', '.', '+', '+', '+', '.', '.', '.', '+', '.', '+', '+', '+', '+', '.', '.', '.'},
                {'.', '.', '+', '.', '.', '+', '.', '+', '.', '.', '+', '.', '.', '.', '.', '.', '.', '.', '+', '.'},
                {'.', '.', '.', '.', '.', '.', '+', '.', '+', '.', '.', '.', '+', '.', '+', '.', '.', '.', '+', '.'},
                {'.', '+', '.', '+', '.', '.', '+', '.', '+', '.', '.', '+', '.', '+', '.', '.', '.', '.', '.', '+'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'+', '+', '+', '+', '.', '.', '+', '.', '.', '.', '+', '.', '.', '+', '+', '+', '.', '.', '.', '.'},
                {'.', '.', '+', '+', '.', '+', '.', '.', '.', '.', '.', '+', '+', '.', '.', '+', '.', '.', '.', '.'},
                {'.', '.', '.', '+', '.', '.', '.', '.', '.', '.', '.', '+', '.', '.', '.', '.', '+', '.', '.', '.'},
                {'.', '+', '+', '.', '.', '+', '.', '.', '.', '.', '+', '+', '.', '+', '+', '.', '.', '.', '+', '.'},
                {'+', '.', '.', '.', '.', '.', '+', '.', '.', '.', '.', '+', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '+', '.', '.', '.', '+', '.', '.', '+', '.', '.', '.', '.', '.', '.', '.', '.'}
        }, new int[]{17, 15}));
        output(maze.nearestExit(new char[][]{{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}}, new int[]{0,1}));
        output(maze.nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2}));
        output(maze.nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}));
        output(maze.nearestExit(new char[][]{{'.','+'}}, new int[]{0,0}));
    }

    private static final char DOT = '.';
    private static final char PLUS = '+';

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<List<Integer>> q = new LinkedList<>();
        int moves = 0;
        q.add(List.of(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = PLUS;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                List<Integer> node = q.poll();
                if (moves > 0 && (node.get(0) == 0 || node.get(1) == 0 || node.get(0) == maze.length - 1 || node.get(1) == maze[0].length - 1)) {
                    return moves;
                }
                if (node.get(0) != 0 && maze[node.get(0) - 1][node.get(1)] == DOT) {
                    // UP
                    q.add(List.of(node.get(0) - 1, node.get(1)));
                    maze[node.get(0) - 1][node.get(1)] = PLUS;
                }
                if (node.get(0) < maze.length - 1 && maze[node.get(0) + 1][node.get(1)] == DOT) {
                    // DOWN
                    q.add(List.of(node.get(0) + 1, node.get(1)));
                    maze[node.get(0) + 1][node.get(1)] = PLUS;
                }
                if (node.get(1) != 0 && maze[node.get(0)][node.get(1) - 1] == DOT) {
                    // LEFT
                    q.add(List.of(node.get(0), node.get(1) - 1));
                    maze[node.get(0)][node.get(1) - 1] = PLUS;
                }
                if (node.get(1) < maze[0].length - 1 && maze[node.get(0)][node.get(1) + 1] == DOT) {
                    // RIGHT
                    q.add(List.of(node.get(0), node.get(1) + 1));
                    maze[node.get(0)][node.get(1) + 1] = PLUS;
                }
            }
            moves++;
        }
        return -1;
    }

}
