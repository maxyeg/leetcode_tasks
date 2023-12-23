import java.util.function.Consumer;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        Utils.output(hr.rob(new int[]{1,2,3,1}));
        Utils.output(hr.rob(new int[] {2,7,9,3,1}));
        Utils.output(hr.rob(new int[] {2,1,1,2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] f = new int[3];
        f[0] = nums[0];
        f[1] = nums[1];
        int max = Math.max(f[0], f[1]), avMax = nums[0];
        for (int i = 2; i < nums.length; i++) {
            f[i % 3] = avMax + nums[i];
            if (f[i % 3] > max) {
                avMax = max;
                max = f[i % 3];
            } else {
                avMax = max;
            }
        }
        return max;
    }
}
