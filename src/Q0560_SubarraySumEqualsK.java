public class Q0560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum;
        for (int start = 0; start < nums.length; start++) {
            sum = nums[start];
            if (sum == k) {
                count++;
            }
            for (int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
