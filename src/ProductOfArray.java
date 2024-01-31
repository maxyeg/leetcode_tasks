import static edu.leetcode.maxeg.utils.Utils.output;

public class ProductOfArray {
    public static void main(String[] args) {
        ProductOfArray main = new ProductOfArray();
        output(main.productExceptSelf(new int[]{1,2,3,4}));
        output(main.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prefixF = new int[l], prefixR = new int[l];
        prefixF[0] = prefixR[l - 1] = 1;
        prefixF[1] = nums[0];
        for (int i = 1; i < l; i++) {
            prefixF[i] = nums[i - 1] * prefixF[i - 1];
            prefixR[l - i - 1] = nums[l - i] * prefixR[l - i];
        }
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = prefixF[i] * prefixR[i];
        }
        return result;
    }
}
