package edu.leetcode.maxeg;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        ac.output(ac.asteroidCollision(new int[] {5,10,-5}));
        ac.output(ac.asteroidCollision(new int[] {8,-8}));
        ac.output(ac.asteroidCollision(new int[] {10,2,-5}));
        ac.output(ac.asteroidCollision(new int[] {-2,-2,1,-2}));
        ac.output(ac.asteroidCollision(new int[] {-2,2,1,-2}));
    }

    public void output(int[] arg) {
        for (int i : arg) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Integer tos = stack.peek();
                if (tos > 0 && i < 0) {
                    if (Math.abs(i) == tos) {
                        stack.pop();
                    } else {
                        while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(i) > stack.peek()) {
                            stack.pop();
                        }
                        if (stack.isEmpty() || stack.peek() < 0) stack.push(i);
                        if (stack.peek() == Math.abs(i)) stack.pop();
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        int[] resArray = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++) {
            resArray[i] = stack.get(i);
        }
        return resArray;
    }
}
