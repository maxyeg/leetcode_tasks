// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[] {-1,3,5,6};
        int what = 0;
        System.out.println(searchInsert(ints, what));
    }

    public static int searchInsert(int[] nums, int target) {
        //return search(0, nums.length - 1, nums, target);
        //if (target == 0) return 0;
        int l = 0, r = nums.length - 1, m = 0;
        do {
            if (l == r && nums[l] != target) {
                if (nums[l] > target) return l;
                else return l + 1;
            }
            m = (l + r) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        } while (l <= r);
        return l;
    }

    public static int search(int l, int r, int[] nums, int wh) {
        if (l > r || r >= nums.length) return -1;
        if (l == r && nums[l] != wh) {
            if (nums[l] > wh) return l - 1;
            else return l + 1;
        }
        int m = (l + r) / 2;
        if (nums[m] == wh) return m;
        else if (nums[m] > wh) return search(l, m-1 , nums, wh);
        else return search(m+1, r, nums, wh);
    }
}