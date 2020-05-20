import java.util.*;

public class Q0870_AdvantageShuffle {
    public static int[] advantageCount(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
            return null;
        }
        // 贪心算法，田忌赛马
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // 哈希图，存放能打败B[i]的元素集合
        HashMap<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int num : B) {
            assigned.put(num, new ArrayDeque<>());
        }
        // 存放不能击败B中元素的A中元素
        Deque<Integer> remaining = new ArrayDeque<>();

        // 遍历sortedA和sortedB, 完善assigned
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (sortedA[i] > sortedB[j]) {
                assigned.get(sortedB[j]).add(sortedA[i]);
                j++;
            } else {
                remaining.add(sortedA[i]);
            }
        }

        int[] res = new int[A.length];
        for (int i = 0; i < res.length; i++) {
            if (assigned.get(B[i]).size() > 0) {
                res[i] = assigned.get(B[i]).pop();
            } else {
                res[i] = remaining.pop();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {2,7,11,15};
        int[] B = {1,10,4,11};
        int[] res = advantageCount(A,B);
    }
}
