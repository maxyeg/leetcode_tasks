import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class DiffTwoArrays {

    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        findDifference(new int[]{1,2,3}, new int[] {2,4,6});
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> d1 = new HashSet<>();
        for (int i : nums1) {
            d1.add(i);
        }
        HashSet<Integer> d2 = new HashSet<>();
        for (int i : nums2) {
            d2.add(i);
        }
        HashSet<Integer> copies  = new HashSet<>();
        for (Integer i : d1) {
            if (d2.contains(i)) {
                copies.add(i);
            }
        }
        for (Integer i : d2) {
            if (d1.contains(i)) {
                copies.add(i);
            }
        }
        Predicate<Integer> predicate = i -> !copies.contains(i);
        return List.of(d1.stream().filter(predicate).collect(Collectors.toList()),
                d2.stream().filter(predicate).collect(Collectors.toList()));
    }
}