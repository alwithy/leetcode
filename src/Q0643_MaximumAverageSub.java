import javax.swing.plaf.IconUIResource;

public class Q0643_MaximumAverageSub {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k < 0 ||nums.length < k) {
            return 0.0f;
        }

        double res = 0.0f;
        int i = 0;
        for (; i < k; i++) {
            res += nums[i];
        }
        double current = res;
        for (; i < nums.length; i++) {
            current = current - nums[i - k] + nums[i];
            res = Math.max(current,res);
        }
        return res/k;
    }
}
