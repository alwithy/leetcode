public class Q0330_PatchingArray {
    public static int minPatches(int[] nums, int n) {
        int len = nums.length;
        //x表示[1..x]已经被凑出
        long x = 0;
        int res = 0;
        int index = 0;
        while (x < n) {
            if (index < len && nums[index] <= x + 1) {
                x += nums[index++];
            } else {
                x += x + 1;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,31,33};
        int n = 2147483647;
        System.out.println(minPatches(arr, n));
    }
}
