package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class SmallestNumberInfiniteSet {
    public static void main(String[] args) {
        SmallestNumberInfiniteSet main = new SmallestNumberInfiniteSet();
        SmallestInfiniteSet set = main.createSet();
        set.addBack(2);
        output(set.popSmallest());
        output(set.popSmallest());
        output(set.popSmallest());
        set.addBack(1);
        output(set.popSmallest());
        output(set.popSmallest());
        output(set.popSmallest());
    }

    private SmallestInfiniteSet createSet() {
        return new SmallestInfiniteSet();
    }

    class SmallestInfiniteSet {

        private final static int N = 1001;
        private final boolean[] presence;
        private int min;

        public SmallestInfiniteSet() {
            presence = new boolean[N];
            for (int i = 1; i < N; i++) {
                presence[i] = true;
            }
            min = 1;
        }

        public int popSmallest() {
            int result = 0;
            if (min <= N) {
                result = min;
                presence[result] = false;
                while (min < N && !presence[min]) {
                    min++;
                }
            }
            return result;
        }

        public void addBack(int num) {
            presence[num] = true;
            if (num < min) {
                min = num;
            }
        }
    }
}
