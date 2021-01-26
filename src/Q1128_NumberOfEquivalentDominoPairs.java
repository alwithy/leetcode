import java.util.HashMap;

public class Q1128_NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        //map的key为 max(cur[0], cur[1]) * 10 + min(cur[0], cur[1])
        //value为出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] curArr : dominoes) {
            int code = Math.max(curArr[0], curArr[1]) * 10 + Math.min(curArr[0], curArr[1]);
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value >= 2) {
                res = (value * (value - 1)) / 2 + res;
            }
        }
        return res;
    }
}
