public class Q0566_ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int count = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[count/nums[0].length][count%nums[0].length];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int[][] res = matrixReshape(nums, 1, 4);
    }
}
