public class Q0457_CircularArrayLoop {
    //此函数把不可能在环中的点设为0
    private static void setZero(int[] nums, int i) {
        //nums[i] 在[-5000,5000]内，length在[1,1000]内
        //加上5000*length是为了让结果为正
        //j为i的下一个点
        int j;
        while (true) {
            j = (i + nums[i] + 5000 * nums.length) % nums.length;
            if (nums[j] * nums[i] < 0 || nums[j] == 0) {
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }
    }

    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        //使用双指针法,j为慢指针，k为快指针
        int j,k,lastJ,lastK;
        for (int i = 0; i < nums.length; i++) {
            j = i;
            k = i;

            while (true) {
                //慢指针走
                lastJ = j;
                j = (j + nums[j] + 5000 * nums.length) % nums.length;
                if (nums[j] * nums[lastJ] < 0 || nums[j] == 0 || j == lastJ) {
                    setZero(nums,i);
                    break;
                }

                //快指针走第一步
                lastK = k;
                k = (k + nums[k] + 5000 * nums.length) % nums.length;
                if (nums[k] * nums[lastK] < 0 || nums[k] == 0 || k == lastK) {
                    setZero(nums,i);
                    break;
                }
                //走第二步
                lastK = k;
                k = (k + nums[k] + 5000 * nums.length) % nums.length;
                if (nums[k] * nums[lastK] < 0 || nums[k] == 0 || k == lastK) {
                    setZero(nums,i);
                    break;
                }

                if (j == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
