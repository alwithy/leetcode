public class Q0565_ArrayNesting {
    public static int arrayNesting(int[] nums) {
        int max = 0;
        int current,j;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length) {
                j = i;
                current = 0;
                while (nums[j] < nums.length) {
                    current++;
                    nums[j] += nums.length;
                    j = nums[j] % nums.length;
                }
                max = Math.max(max,current);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(arr));
    }
}
