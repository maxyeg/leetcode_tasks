package edu.leetcode.maxeg;

import java.util.Stack;

import static edu.leetcode.maxeg.utils.Utils.output;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        output(ds.decodeString("3[a]2[bc]"));
        output(ds.decodeString("3[a2[c]]"));
        output(ds.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        output(ds.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        Stack<String> strs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // Read number, push to nums stack
            // if [ - read string , put chars to stack
            // if ] - pop chars stack, pop nums stack times
            // if just string - copy to output
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (Character.isDigit(s.charAt(j))) {
                    j++;
                }
                strs.push(s.substring(i, j));
                i = j - 1;
            } else if ('[' == s.charAt(i)) {
                strs.push(String.valueOf(s.charAt(i)));
            } else if (']' == s.charAt(i)) {
                String tmp = strs.pop();
                while (!strs.peek().equals("[")) {
                    tmp = strs.pop().concat(tmp);
                }
                strs.pop();
                strs.push(tmp.repeat(Integer.parseInt(strs.pop())));
            } else {
                int j = i;
                while (j < s.length() && 'a' <= s.charAt(j) && s.charAt(j) <= 'z') {
                    j++;
                }
                if (i < j) {
                    strs.push(s.substring(i, j));
                    i = j - 1;
                }
            }
        }
        String tmp = strs.pop();
        while (!strs.empty()) {
            tmp = strs.pop().concat(tmp);
        }
        return tmp;
    }
}
