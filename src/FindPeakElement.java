import java.util.Stack;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,3,1}));
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[0] > nums[1]) return 0;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) return i;
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
            }
        }
        return -1;
    }
}