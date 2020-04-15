public class Q0167_TwoSumSortedInput {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        int left, right, mid;
        for (int i = 0; i < numbers.length; i++) {
            left = i + 1;
            right = numbers.length - 1;
            while (left < right) {
                mid = left + ((right - left) >> 1);
                if (numbers[mid] < target - numbers[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (numbers[i] + numbers[left] == target) {
                res[0] = i + 1;
                res[1] = left + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0};
        int[] res = twoSum(nums,-1);
    }
}
