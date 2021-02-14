public class Q5678_MinimumLimitOfBallsInBag {
    public static int minimumSize(int[] nums, int maxOperations) {
        //对值域进行二分查找
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (getCost(nums, mid) > maxOperations) {
                l = mid + 1;
            } else {//cost <= maxOperations
                if (getCost(nums, mid - 1) > maxOperations) {
                    l = mid;
                    break;
                }
                r = mid - 1;
            }
        }

        return l;
    }

    public static int getCost(int[] nums, int max) {
        int cost = 0;
        for (int num : nums) {
            cost += (num - 1) / max;
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int max = 2;
        System.out.println(minimumSize(nums, max));
    }
}
