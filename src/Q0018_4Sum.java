import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0018_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        List<Integer> cur;
        int N = nums.length;
        //排序加指针，类似3Sum
        Arrays.sort(nums);
        for (int i = 0; i < N - 3; i++) {
            //去重
            while (i - 1 >= 0 && i < N - 3
                    && nums[i - 1] == nums[i]) {
                i++;
            }
            if (i >= N - 3) break;

            //判断当前最小值是否大于target
            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }

            //判断当前最大值是否小于target
            int max1 = nums[i] + nums[N - 3] + nums[N - 2] + nums[N - 1];
            if (max1 < target) {
                continue;
            }

            for (int j = i + 1; j < N - 2; j++) {
                //去重
                while (j - 1 >= i + 1 && j < N - 2
                        && nums[j - 1] == nums[j]) {
                    j++;
                }
                if (j >= N - 2) break;

                //同样判断最小值与最大值
                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) {
                    break;
                }
                int max2 = nums[i] + nums[j] + nums[N - 2] + nums[N - 1];
                if (max2 < target) {
                    continue;
                }

                //双指针法，类似3Sum
                int l = j + 1;
                int r = N - 1;
                int sum,curLeft,curRight;
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[l]);
                        cur.add(nums[r]);
                        res.add(cur);

                        //去重
                        curLeft = nums[l];
                        while (l < r && nums[l] == curLeft) l++;
                        curRight = nums[r];
                        while (r > l && nums[r] == curRight) r--;
                    } else if (sum > target) {
                        r--;
                    } else {//sum < target
                        l++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(
                fourSum(arr,0)
        );
    }
}
