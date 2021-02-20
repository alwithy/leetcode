import java.util.HashMap;
import java.util.HashSet;

public class Q0697_DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        //用一个HashMap记录每个元素出现的频率，
        //滑动窗口法
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;//max记录最大出现次数
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        int res = Integer.MAX_VALUE;
        //窗口范围[l..r]
        int l = 0, r = 0;
        //sub记录当前窗口中的元素及出现次数
        HashMap<Integer, Integer> sub = new HashMap<>();
        //curMax记录窗口中出现次数达到max的元素
        HashSet<Integer> curMax = new HashSet<>();
        while (r < nums.length) {
            sub.put(nums[r], sub.getOrDefault(nums[r], 0) + 1);
            if (sub.get(nums[r]) == max) {
                curMax.add(nums[r]);
            }

            while (!curMax.isEmpty() && l <= r) {
                sub.put(nums[l], sub.get(nums[l]) - 1);
                if (curMax.contains(nums[l])) {
                    if (curMax.size() > 1) {
                        curMax.remove(nums[l]);
                    } else {
                        break;
                    }
                }
                l++;
            }

            if (!curMax.isEmpty()) {
                res = Math.min(res, r - l + 1);
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1};
        System.out.println(findShortestSubArray(arr));
    }
}
