public class Q0045_JumpGame {
    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        // 贪心算法
        int maxPosition = 0; // 下一步可以到达的最远处
        int step = 0; // 当前的步数
        int end = 0; // 这一步可以到达的最远处
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 走到这一步能到的边界时
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
