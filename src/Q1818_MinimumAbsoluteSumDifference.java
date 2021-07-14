import java.util.Arrays;

public class Q1818_MinimumAbsoluteSumDifference {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //排序后二分
        int mod = 1000000007;
        //sum记录差值和
        int sum = 0, n = nums1.length;
        int[] help = new int[n];
        System.arraycopy(nums1, 0, help, 0, n);
        Arrays.sort(help);
        //max记录交换后差值的最大减少值
        int max = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(nums2[i], help);
            max = Math.max(max, diff - Math.abs(nums2[i] - help[j]));
            if (j > 0) {
                max = Math.max(max, diff - Math.abs(nums2[i] - help[j - 1]));
            }
        }

        return (sum - max + mod)%mod;
    }

    //该函数返回help数组中大于等于target且最接近target的值的索引
    //若help所有值都比target小，则返回help中的最大值的索引(help.length - 1)
    private static int binarySearch(int target, int[] help) {
        int l = 0, r = help.length - 1;
        if (help[r] <= target) {
            return r;
        }
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (help[mid] < target) {
                l = mid + 1;
            } else {
                if (mid - 1 >= 0 && help[mid - 1] < target) {
                    l = mid;
                    break;
                }
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] num1 = {1,10,4,4,2,7};
        int[] num2 = {9,3,5,1,7,4};
        System.out.println(minAbsoluteSumDiff(num1, num2));
    }
}
