import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class RemoveStarsFromString {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
    public static String removeStars(String s) {
//        String result = s;
//        while (result.contains("*")) {
//            result = result.replaceFirst("[a-z]\\*", "");
//        }
//        return result;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }
}