package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        output(rw.reverseWords("the sky is blue"));
        output(rw.reverseWords("  hello world  "));
        output(rw.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] ar = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        String space = " ";
        for (int i = ar.length - 1; i > 0; i--) {
            sb.append(ar[i]).append(space);
        }
        if (ar.length > 0) {
            sb.append(ar[0]);
        }
        return sb.toString();
    }
}
