import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q5665_RestoreTheArrayFromAdjacentPairs {
    public static int[] restoreArray(int[][] adjacentPairs) {
        //key为左侧元素，value为右侧元素
        //对每一对pair，都正反各插入一次
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            put(pair[0], pair[1], map);
            put(pair[1], pair[0], map);
        }

        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        int cur = 0, index = 0;

        //第一个数和最后一个数对应的list中只有一个数字,找到其中一个
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                cur = key;
                break;
            }
        }

        //set存放用过的数字
        HashSet<Integer> set = new HashSet<>();
        while (index < n) {
            res[index++] = cur;
            set.add(cur);
            List<Integer> list = map.get(cur);
            if (index == n) {
                break;
            }
            if (!set.contains(list.get(0))) {
                cur = list.get(0);
            } else {
                cur = list.get(1);
            }
        }

        return res;
    }

    public static void put(int i, int j, HashMap<Integer, List<Integer>> map) {
        if (!map.containsKey(i)) {
            map.put(i, new ArrayList<>());
        }
        map.get(i).add(j);
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1}, {3,4}, {3,2}};
        int[] res = restoreArray(arr);
    }
}
