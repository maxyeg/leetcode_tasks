import static edu.leetcode.maxeg.utils.Utils.output;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = new char[] {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'};
        int res = sc.compress(chars);
        output(res);
        output(chars);
        chars = new char[]{'o','o','o','o','o','o','o','o','o','o'};
        res = sc.compress(chars);
        output(res);
        output(chars);
        chars = new char[] {'a'};
        res = sc.compress(chars);
        output(res);
        output(chars);
    }

    public int compress(char[] chars) {
        int newIndex = 0;
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            int num = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                num++;
            }
            chars[newIndex] = c;
            if (num != 1) {
                int numDigits = (int) Math.ceil(Math.log10(num));
                if ((int) Math.pow(10, numDigits) == num) {
                    chars[++newIndex] = Character.forDigit(1, 10);
                    for (int j = 1; j <= numDigits; j++) {
                        chars[++newIndex] = Character.forDigit(0, 10);
                    }
                } else {
                    int round = 0;
                    while (true) {
                        ++newIndex;
                        ++round;
                        if (num < 10) {
                            chars[newIndex] = Character.forDigit(num, 10);
                            break;
                        } else {
                            int digit = (int) Math.floor(num / Math.pow(10, numDigits - round));
                            chars[newIndex] = Character.forDigit(digit, 10);
                            num = (int) (num - digit * Math.pow(10, numDigits - round));
                            round++;
                        }
                    }
                }
            }
            ++newIndex;
        }
        return newIndex;
    }
}
