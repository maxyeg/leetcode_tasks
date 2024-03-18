package edu.leetcode.maxeg;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String min, max;
        if (a.length() <= b.length()) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        while (min.length() != max.length()) {
            min = "0".concat(min);
        }
        boolean shift = false;
        for (int i = min.length() - 1; i >= 0; i--) {
            String tmp;
            char c1 = min.charAt(i);
            char c2 = max.charAt(i);
            if (c1 != c2) {
                if (!shift) {
                    tmp = "1";
                } else {
                    tmp = "0";
                }
            } else if (c1 == '1') {
                if (shift) {
                    tmp = "1";
                } else {
                    tmp = "0";
                    shift = true;
                }
            } else {
                if (shift) {
                    tmp = "1";
                    shift = false;
                } else {
                    tmp = "0";
                }
            }
            sb.insert(0, tmp);
        }
        if (shift) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}
