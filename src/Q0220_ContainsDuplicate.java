import java.util.TreeSet;

public class Q0220_ContainsDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove((long)nums[i - k - 1]);
            }

            Long big = set.ceiling((long)nums[i]);
            if (big != null && big <= (long)nums[i] + t) {
                return true;
            }

            Long small = set.floor((long)nums[i]);
            if (small != null && small >= (long)nums[i] - t) {
                return true;
            }

            set.add((long)nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 3));
    }
}
