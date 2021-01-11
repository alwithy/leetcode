import java.util.HashMap;

public class Q1655_DistributeRepeatingIntegers {
    public static boolean canDistribute(int[] nums, int[] quantity) {
        //统计数组中每个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int m = map.keySet().size();
        int[] ctn = new int[m];
        int idx = 0;
        for (int key : map.keySet()) {
            ctn[idx++] = map.get(key);
        }

        //穷举所有的顾客集合j，计算cost
        int n = quantity.length;
        int[] cost = new int[1 << n];
        for (int j = 1; j < (1 << n); j++) {
            for (int i = 0; i < n; i++) {
                if ((j & (1 << i)) != 0) {
                    cost[j] = cost[j - (1 << i)] + quantity[i];
                    break;
                }
            }
        }


        //dp[i][j]表示ctn[0..i]能否满足顾客集合j
        boolean[][] dp = new boolean[m][1 << n];
        //base case，满足空集合均为true
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }
        //只使用ctn[0]的情况
        for (int j = 1; j < (1 << n); j++) {
            dp[0][j] = ctn[0] >= cost[j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < (1 << n); j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i][j]) {
                    continue;
                }
                //穷举集合j的所有子集s,使用ctn[i]满足子集s
                //剩下的集合j - s使用ctn[0..i - 1]满足,即dp[i - 1][j - s]
                for (int s = j; s > 0; s = (s - 1) & j) {
                    dp[i][j] = dp[i - 1][j - s] && ctn[i] >= cost[s];
                    if (dp[i][j]) {
                        break;
                    }
                }
            }
        }

        return dp[m - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int[] quantity = {2};
        System.out.println(canDistribute(nums, quantity));
    }
}
