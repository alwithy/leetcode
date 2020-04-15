import java.util.HashMap;

public class Q0532_KdiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length <= 0 || k < 0) {
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) {
                    res++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
