import java.util.HashMap;
import java.util.HashSet;

public class Q0128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 0;
                while (set.contains(num)) {
                    len++;
                    num++;
                }
                res = Math.max(len, res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-6,8,-5,7,-9,-1,-7,-6,-9,-7,5,7,-1,-8,-8,-2,0};
        System.out.println(longestConsecutive(arr));
    }
}
