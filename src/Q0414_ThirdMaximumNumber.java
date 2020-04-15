import java.util.Arrays;
import java.util.Collections;

public class Q0414_ThirdMaximumNumber {
    public static int thirdMaximumNum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }

        //res记录最大的三个数
        int[] res = new int[3];
        //updateTimes记录res数组的更新次数
        int updateTimes = 1;
        res[2] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (updateTimes < 3) {
                boolean hasThisNum = false;
                for (int j = 2; j >= 3 - updateTimes; j--) {
                    if (res[j] == nums[i]) {
                        hasThisNum = true;
                    }
                }

                if (!hasThisNum) {
                    res[3 - ++updateTimes] = nums[i];
                    Arrays.sort(res, 3 - updateTimes, 3);
//                    if (updateTimes == 2 && res[2] < res[1]) {
//                        int temp = res[2];
//                        res[2] = res[1];
//                        res[1] = temp;
//                    }
//
//                    if (updateTimes == 3 && !(res[0] < res[1] && res[1] < res[2])) {
//                        Arrays.sort(res, 3 - updateTimes, 3);
//                    }
                }
            } else {
                if (nums[i] > res[0]) {
                    if (nums[i] < res[1]) {
                        res[0] = nums[i];
                    } else if (nums[i] > res[1] && nums[i] < res[2]) {
                        res[0] = res[1];
                        res[1] = nums[i];
                    } else if (nums[i] > res[2]) {
                        res[0] = res[1];
                        res[1] = res[2];
                        res[2] = nums[i];
                    }
                }
            }
        }

        if (updateTimes < 3) {
            return res[2];
        } else {
            return res[0];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -30000,2};
        System.out.println(thirdMaximumNum(nums));
    }
}
