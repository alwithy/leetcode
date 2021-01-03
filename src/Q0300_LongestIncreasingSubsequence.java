public class Q0300_LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //贪心+二分
        //len记录目前的最长上升子序列长度
        int len = 1;
        int n = nums.length;
        //is[n]表示长度为n + 1的上升子序列最后一个数字的最小值
        int[] is = new int[n];
        is[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > is[len - 1]) {
                len++;
                is[len - 1] = nums[i];
                continue;
            }

            //找到L满足is[L - 1] < nums[i] < is[L]，然后更新is[L]
            int l = 0;
            int r = len - 1;
            int mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (is[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    if (mid - 1 >= l && is[mid - 1] < nums[i]) {
                        l = mid;
                        break;
                    }
                    r = mid - 1;
                }
            }
            is[l] = nums[i];
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
