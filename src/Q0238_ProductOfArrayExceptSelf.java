public class Q0238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 动态规划
        int length = nums.length;
        int[] res = new int[length];
        // beforeI[i]表示从nums[0]到nums[i - 1]的积
        int[] beforeI = new int[length];
        beforeI[0] = 1;
        // afterI[i]表示从nums[i + 1]到nums[nums.length - 1]的积
        int[] afterI = new int[length];
        afterI[length - 1] = 1;

        // 计算两个工具数组
        for (int i = 1; i < length; i++) {
            beforeI[i] = beforeI[i - 1] * nums[i - 1];
            afterI[length - 1 - i] = afterI[length - i] * nums[length - i];
        }

        for (int i = 0; i < length; i++) {
            res[i] = beforeI[i] * afterI[i];
        }

        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 进阶，只用常数空间
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;

        // 使用res存放before数组
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // 计算r的时候顺便计算res
        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] res = productExceptSelf2(arr);
    }
}
