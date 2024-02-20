package edu.leetcode.maxeg;

import java.util.Stack;

import static edu.leetcode.maxeg.utils.Utils.output;

public class StockSpan {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        output(spanner.next(100));
        output(spanner.next(80));
        output(spanner.next(60));
        output(spanner.next(70));
        output(spanner.next(60));
        output(spanner.next(75));
        output(spanner.next(85));
    }
}

class StockSpanner {

    private final Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int span = 1;
        while (!stack.empty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[] {price, span});
        return span;
    }

}