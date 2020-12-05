import java.util.HashMap;

public class Q0659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        //官方题解2，贪心
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int count = countMap.get(num);
            if (count > 0) {
                int prvCount = endMap.getOrDefault(num - 1, 0);
                if (prvCount > 0) {
                    countMap.put(num, count - 1);
                    endMap.put(num - 1, prvCount - 1);
                    endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(num, count - 1);
                        countMap.put(num + 1, count1 - 1);
                        countMap.put(num + 2, count2 - 1);
                        endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
