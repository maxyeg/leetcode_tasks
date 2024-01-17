package edu.leetcode.maxeg;

import static edu.leetcode.maxeg.utils.Utils.output;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        GreatestCommonDivisor main = new GreatestCommonDivisor();
        output(main.gcdOfStrings("REQAGELREQAGELREQAGELREQAGELREQAGEL", "REQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGEL"));
        output(main.gcdOfStrings("FBFKOXFBFKOXFBFKOXFBFKOXFBFKOX", "FBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOX"));
        output(main.gcdOfStrings("ABCABC", "ABC"));
        output(main.gcdOfStrings("ABABAB", "ABAB"));
        output(main.gcdOfStrings("LEET", "CODE"));
    }

    public String gcdOfStrings(String str1, String str2) {
        String high, low;
        int highLen, lowLen;
        if (str1.length() > str2.length()) {
            high = str1;
            highLen = str1.length();
            low = str2;
            lowLen = str2.length();
        } else {
            high = str2;
            highLen = str2.length();
            low = str1;
            lowLen = str1.length();
        }
        if (highLen % lowLen == 0) {
            if (high.equals(low.repeat(highLen / lowLen))) {
                return low;
            }
        }
        for (int i = lowLen / 2; i > 0; i--) {
            if (lowLen % i == 0 && highLen % i == 0) {
                String tmp = low.substring(0, i);
                if (low.equals(tmp.repeat(lowLen / i)) && high.equals(tmp.repeat(highLen / i))) {
                    return tmp;
                }
            }
        }
        return "";
    }
}
