package edu.leetcode.maxeg;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.output;

public class TwoStringsClose {
    public static void main(String[] args) {
        TwoStringsClose tsc = new TwoStringsClose();
        output(tsc.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
        output(tsc.closeStrings("abbzzca", "babzzcz"));
        output(tsc.closeStrings("abc", "bca"));
        output(tsc.closeStrings("a", "aa"));
        output(tsc.closeStrings("cabbba", "abbccc"));
    }

    public boolean closeStrings(String word1, String word2) {
        final int N = 26;
        final char A = 'a';
        if (word1.length() != word2.length()) return false;
        if (word1.equals(word2)) return true;
        int[] arr1 = new int[N], arr2 = new int[N];
        for (int i = 0; i < word1.length(); i++) {
            arr1[word1.charAt(i) - A]++;
            arr2[word2.charAt(i) - A]++;
        }
        for (int i = 0; i < N; i++) {
            if (arr1[i] == arr2[i]) continue;
            if (arr1[i] == 0 || arr2[i] == 0) return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
