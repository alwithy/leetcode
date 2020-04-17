public class Q0581_ShortedUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int begin = nums.length;//子序列开始的index
        int end = -1;//子序列结束的index
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean flag = false;//flag为true表示该段数组是逆序的
        //顺序遍历，找出需要排序的子数组中的最小值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            } else {
                flag = false;
            }
            if (flag) {
                min = Math.min(min,nums[i]);
            }
        }
        //顺序遍历，找出最小值的正确索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                begin = i;
                break;
            }
        }

        //逆序遍历，找出逆序子数组最大值
        flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            } else {
                flag = false;
            }
            if (flag) {
                max = Math.max(max,nums[i - 1]);
            }
        }
        //找出最大值的正确索引
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        if (end - begin + 1 > 0) {
            return end - begin + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(arr));
    }

}
