package edu.leetcode.maxeg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainLettersFromPhoneDigits {

    public static Map<Character, List<? extends Object>> mapping = Map.ofEntries(
            Map.entry('2', List.of("a", "b", "c")),
            Map.entry('3', List.of("d", "e", "f")),
            Map.entry('4', List.of("g", "h", "i")),
            Map.entry('5', List.of("j", "k", "l")),
            Map.entry('6', List.of("m", "n", "o")),
            Map.entry('7', List.of("p", "q", "r", "s")),
            Map.entry('8', List.of("t", "u", "v")),
            Map.entry('9', List.of("w", "x", "y", "z"))
    );

    public static void main(String[] args) {

        double d1 = Math.pow(10, 100), d2 = Math.pow(10, -100);

        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        List<String> result = new LinkedList<>();

        for (char c : digits.toCharArray()) {
            List<String> variants = (List<String>) mapping.get(c);
            if (result.isEmpty()) {
                result.addAll(variants);
            } else {
                List<String> intermediateResults = new LinkedList<>();
                for (String ir : result) {
                    for (String v : variants) {
                        intermediateResults.add(ir.concat(v));
                    }
                }
                result = intermediateResults;
            }
        }

        return result;
    }

}