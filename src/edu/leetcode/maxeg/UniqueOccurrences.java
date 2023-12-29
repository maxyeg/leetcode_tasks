package edu.leetcode.maxeg;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        HashSet<Integer> occs = new HashSet();
        for (int i : map.values()) {
            if (!occs.contains(i)) {
                occs.add(i);
            } else {
                return false;
            }
        }
        return true;
    }
}
