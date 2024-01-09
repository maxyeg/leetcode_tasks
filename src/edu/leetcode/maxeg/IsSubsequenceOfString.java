package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class IsSubsequenceOfString {
    public static void main(String[] args) {
        IsSubsequenceOfString main = new IsSubsequenceOfString();
        output(main.isSubsequence("abc", "ahbgdc"));
        output(main.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int lastIndex = 0;
        for (char c : s.toCharArray()) {
            boolean found = false;
            for (int i = lastIndex; i < t.length(); i++) {
                if (c == t.charAt(i)) {
                    lastIndex = i + 1;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
