package edu.leetcode.maxeg;

import edu.leetcode.maxeg.utils.Utils;

public class MaximumNumberOfVowels {
    public static void main(String[] args) {
        MaximumNumberOfVowels mnov = new MaximumNumberOfVowels();
        Utils.output(mnov.maxVowels("weallloveyou", 7));
        Utils.output(mnov.maxVowels("abciiidef", 3));
        Utils.output(mnov.maxVowels("aeiou", 2));
        Utils.output(mnov.maxVowels("leetcode", 3));
    }

    public int maxVowels(String s, int k) {
        int currVowels = countVowelsInWindow(s, 0, k);
        int maxVowels = currVowels;
        for (int i = 1; i < s.length() - k + 1; i++) {
            if (isVowel(s.charAt(i - 1))) {
                currVowels -= 1;
            }
            if (isVowel((s.charAt(i + k - 1)))) {
                currVowels += 1;
            }
            if (currVowels > maxVowels) maxVowels = currVowels;
        }
        return maxVowels;
    }

    private int countVowelsInWindow(String s, int start, int k) {
        int vowels = 0;
        for (int i = start; i < start + k; i++) {
            if (isVowel(s.charAt(i))) vowels++;
        }
        return vowels;
    }

    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' );
    }
}
