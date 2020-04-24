import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0015_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        //排序加双指针，注意排除重复元素
        Arrays.sort(nums);
        int l,r;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    res.add(cur);
                    //排除左边界重复元素
                    int lastLeft = nums[l];
                    while (l < nums.length && nums[l] == lastLeft) l++;
                    //处理右边界
                    int lastRight = nums[r];
                    while (r >= 0 && nums[r] == lastRight) r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }
            }

            //排除相同的nums[i]
            int lastNum = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == lastNum) {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
    }
}
