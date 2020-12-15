import java.util.*;

public class Q0416_PartitionEqualSubsetSum {
    //使用TreeSet剪枝
    public static boolean canPartition1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        //set存放已经出现过的sum
        Set<Integer> set = new TreeSet<>();
        //dp[i] == true表示数组中部分数的和为i
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        set.add(0);
        int len = nums.length;
        //list存放本轮新增的和
        List<Integer> list;
        Iterator<Integer> iterator;
        for (int i = 0; i < len; i++) {
            list = new ArrayList<>();
            iterator = set.iterator();
            while (iterator.hasNext()) {
                int cur = iterator.next() + nums[i];
                if (cur == sum) {
                    return true;
                }
                if (cur < sum) {
                    dp[cur] = true;
                    list.add(cur);
                }
            }
            set.addAll(list);
        }
        return false;
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        //dp[i] == true表示数组中部分数的和为i
        boolean[] dp = new boolean[sum + 1];
        //max表示目前为止所有数的和
        int max = 0;
        dp[0] = true;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            max += nums[i];
            for (int j = Math.min(sum, max); j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1};
        System.out.println(canPartition(arr));
    }
}
