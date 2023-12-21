// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MaxAvgSubArr {

    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int window = 0;
        double maxAvg = -Double.MAX_VALUE;
        int i;
        for (i = 0; i < k; i++) {
            window += nums[i];
        }
        maxAvg = Math.max(maxAvg, (double) window / k);
        // move window till the end
        for (i = k; i < nums.length; i++) {
            window = window + nums[i] - nums[i - k];
            maxAvg = Math.max(maxAvg, (double) window / k);
        }
        return maxAvg;
    }
}