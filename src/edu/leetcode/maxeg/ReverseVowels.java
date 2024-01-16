package edu.leetcode.maxeg;

import java.util.Stack;

import static edu.leetcode.maxeg.utils.Utils.output;

public class ReverseVowels {

    private static final String VOWELS = "AEIOUaeiou";

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        output(rv.reverseVowels(" "));
        output(rv.reverseVowels("hello"));
        output(rv.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isVowel(c)) {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            for (int i = 0; i < s.length(); i ++) {
                if (isVowel(s.charAt(i))) {
                    sb.append(stack.pop());
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else {
            return s;
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }
}
