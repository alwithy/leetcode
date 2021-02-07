import java.util.Arrays;

public class Q5675_ClosestSubsequenceSum {
    public static int minAbsDifference(int[] nums, int goal) {
        //分成两个数组，分别状态压缩
        int n = nums.length/2, m = nums.length - n;
        int[] leftSum = new int[1 << n], rightSum = new int[1 << m];
        int res = Math.abs(goal);
        
        //左半部分数组
        for (int i = 1; i < leftSum.length; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    leftSum[i] = leftSum[i - (1 << j)] + nums[j];
                    res = Math.min(res, Math.abs(leftSum[i] - goal));
                    break;
                }
            }
        }
        Arrays.sort(leftSum);

        //右半部分
        for (int i = 1; i < rightSum.length; i++) {
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    rightSum[i] = rightSum[i - (1 << j)] + nums[n + j];
                    res = Math.min(res, Math.abs(rightSum[i] - goal));
                }
            }
        }
        Arrays.sort(rightSum);

        //双指针
        int p1 = 0, p2 = rightSum.length - 1;
        while (p1 < leftSum.length && p2 >= 0) {
            int sum = leftSum[p1] + rightSum[p2];
            res = Math.min(res, Math.abs(sum - goal));
            if (sum > goal) {
                p2--;
            } else if (sum < goal) {
                p1++;
            } else {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-6651,401,-8998,-9269,-9167,7741,-9699};
        int goal = 30536;
        System.out.println(minAbsDifference(nums, goal));
    }
}
