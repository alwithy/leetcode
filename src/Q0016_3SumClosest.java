import java.util.Arrays;

public class Q0016_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int l,r,cur;
        int closet = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                cur = nums[i] + nums[l] + nums[r];
                if (cur == target) {
                    return target;
                } else if (cur > target) {
                    if (Math.abs(target - cur) <= Math.abs(target - closet)) {
                        closet = cur;
                    }
                    r--;
                } else {//cur < target
                    if (Math.abs(target - cur) <= Math.abs(target - closet)) {
                        closet = cur;
                    }
                    l++;
                }
            }
        }

        return closet;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0};
        System.out.println(
                threeSumClosest(arr,-100)
        );
    }
}
