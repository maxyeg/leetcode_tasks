public class MainMyAtoi {

    public static final char PLUS_SIGN = '+';
    public static final char MINUS_SIGN = '-';
    public static final char ZERO = '0';
    private static final int MINUS_ONE = -1;

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
    }

    public static int myAtoi(String s) {
        s = s.stripLeading();
        boolean negative = false;
        if (s.isEmpty()) return 0;
        if (s.charAt(0) == MINUS_SIGN || s.charAt(0) == PLUS_SIGN) {
            if (s.charAt(0) == MINUS_SIGN) {
                negative = true;
            }
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                break;
            }
            if (!(ZERO == c && sb.isEmpty())) {
                sb.append(c);
            }
        }

        long res = 0;
        try {
            res = Long.parseLong(sb.toString());
        } catch (NumberFormatException e) {
            if (sb.length() >= 19) res = Long.MAX_VALUE;
        }
        if (negative) {
            res = res * (MINUS_ONE);
        }
        int resInt = 0;
        if (res > Integer.MAX_VALUE) {
            resInt = Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            resInt = Integer.MIN_VALUE;
        } else {
            resInt = (int) res;
        }
        return resInt;
    }
}
