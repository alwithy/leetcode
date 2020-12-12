import java.util.Deque;
import java.util.LinkedList;

public class Q0376_WiggleSubsequence {
    //普通动态规划
    public static int wiggleMaxLength1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int len = nums.length;
        //up[i]:num[0..i]的子序列中最后一个数字大于倒数第二个数字的最长摆动序列长度
        int[] up = new int[len];
        up[0] = 1;
        int[] down = new int[len];
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[len - 1], down[len - 1]);
    }

    //优化空间
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int len = nums.length;
        //up[i]:num[0..i]的子序列中最后一个数字大于倒数第二个数字的最长摆动序列长度
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        int[] nums = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
        System.out.println(wiggleMaxLength(nums));
    }
}
