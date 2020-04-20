import java.util.HashMap;

public class Q0697_DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        //用一个HashMap记录每个元素出现的频率，
        //找到其中频率最多的值，分别找最短连续子数组
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;//max记录最大出现次数
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        int min = Integer.MAX_VALUE;
        for (int value : map.keySet()) {
            if (map.get(value) == max) {
                int left = 0;
                for (; left < nums.length; left++) {
                    if (nums[left] == value) {
                        break;
                    }
                }
                int right = nums.length - 1;
                for (; right >= 0; right--) {
                    if(nums[right] == value) {
                        break;
                    }
                }
                min = Math.min(min, right - left + 1);
            }
        }
        return min;
    }
}
