// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MergeStringsAlternatively {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqreee"));
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        short maxLength = (short) Math.max(word1.length(), word2.length());
        for (short i = 0; i < maxLength; i++) {
            try {
                sb.append(word1.charAt(i));
            } catch (IndexOutOfBoundsException e) {
                // skip shorter word
            }
            try {
                sb.append(word2.charAt(i));
            } catch (IndexOutOfBoundsException e) {
                // skip shorter word
            }
        }
        return sb.toString();
    }
}