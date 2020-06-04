import java.util.*;

public class Q0954_ArrayOfDoubledPairs {
    public static boolean canReorderDoubled(int[] A) {
        if (A == null || A.length < 2) {
            return true;
        }

        // 如果每个元素都与另一个能组成一对的话，则true
        // 组成一对的条件是一个元素是另一个元素的两倍
        // 考虑到有重复元素，所以用HashMap来记录数组中的元素及对应索引
        // 补充，按照绝对值从小到大的顺序找
        Integer[] B = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        Deque<Integer> deque;
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                deque = new ArrayDeque<>();
                deque.add(i);
                map.put(B[i], deque);
            }
        }
        // 遍历数组为每一个元素找另一对，找过的元素就标记
        // 标记通过对该元素的值增加20万 + 1来完成
        int value = 100_000;// 十万
        for (int i = 0; i < A.length; i++) {
            if (B[i] <= value) {
                if (map.containsKey(2 * B[i])) {
                    int cur = map.get(2 * B[i]).pop();
                    if (cur == i) {
                        if (map.get(2 * B[i]).isEmpty()) {
                            return false;
                        } else {
                            cur = map.get(2 * B[i]).pop();
                        }
                    }
                    B[cur] += 2 * value + 1;
                    if (map.get(2 * B[i]).isEmpty()) {
                        map.remove(2 * B[i]);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(canReorderDoubled(arr));
    }
}
