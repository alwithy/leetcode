public class Q5639_FindMinimumTimeToFinishAllJobs {
    public static int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        //cost[i]表示完成工作集合i所需要的总时间
        int[] cost = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cost[i] = cost[i - (1 << j)] + jobs[j];
                    break;
                }
            }
        }

        //dp[j][i] 表示前j + 1个人完成工作集合i所需的最小时间
        int[][] dp = new int[k][1 << n];

        //base case,只有一个人的情况
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = cost[i];
        }

        for (int j = 1; j < k; j++) {
            for (int i = 1; i < (1 << n); i++) {
                int minCost = Integer.MAX_VALUE;
                //穷举集合i的所有子集s,尝试把每一种s分配给最后一个人
                //找到所有情况中总耗时的最小值
                for (int s = i; s > 0; s = (s - 1) & i) {
                    //                      前j人的耗时       最后一个人的耗时
                    int curCost = Math.max(dp[j - 1][i - s], cost[s]);
                    minCost = Math.min(minCost, curCost);
                }
                dp[j][i] = minCost;
            }
        }

        return dp[k - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        int[] jobs = {1,2,4,7,8};
        int k = 2;
        System.out.println(minimumTimeRequired(jobs, k));
    }
}
