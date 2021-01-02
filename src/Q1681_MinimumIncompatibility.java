public class Q1681_MinimumIncompatibility {
    public static int minimumIncompatibility(int[] nums, int k) {
        //状态压缩dp
        int n = nums.length;
        int total = 1 << n;

        //value存放合法子集的最大值最小值之差，不合法则标为-1
        int[] value = new int[total];
        for (int i = 0; i < total; i++) {
            if (Integer.bitCount(i) == n / k) {//选中了n/k个数
                int[] curSub = new int[16];//哈希表，curSub[i]表示数字i出现的次数
                int min = 16, max = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        curSub[nums[j]]++;
                        max = Math.max(max, nums[j]);
                        min = Math.min(min, nums[j]);
                    }
                }
                boolean flag = true;
                //检查选中的数字中有没有重复
                for (int j = 0; j < 16; j++) {
                    if (curSub[j] > 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    value[i] = max - min;
                } else {
                    value[i] = -1;
                }
            } else {
                value[i] = -1;
            }
        }

        //dp[i]表示选中'i'这部分数字（即i二进制中对应位为1的nums中的数字）的最小不兼容性和
        int[] dp = new int[total];
        for (int i = 1; i < total; i++) {
            dp[i] = -1;
            if (Integer.bitCount(i) % (n / k) == 0) {
                //sub记录可以选择的数字
                int sub = i;

                while (sub > 0) {
                    //如果sub是有效子集，并且除去sub之外剩下的数依然能组成若干有效子集
                    if (value[sub] > -1 && dp[i ^ sub] > -1) {
                        int cur = value[sub] + dp[i ^ sub];

                        if (dp[i] == -1) {
                            dp[i] = cur;
                        } else {
                            dp[i] = Math.min(dp[i], cur);
                        }
                    }
                    //穷举所有情况，注意只有当i的二进制位为1时，sub对应二进制位才能为1
                    sub = (sub - 1) & i;
                }
            }
        }

        return dp[total - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,4};
        int k = 2;
        System.out.println(minimumIncompatibility(arr, k));
    }
}
