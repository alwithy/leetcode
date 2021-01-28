public class Q0724_FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curSum = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (curSum * 2 + nums[i] == sum) {
                res = i;
                break;
            }
            curSum += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
