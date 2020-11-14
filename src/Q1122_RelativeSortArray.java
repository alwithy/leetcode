import java.util.Arrays;
import java.util.HashMap;

public class Q1122_RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null) return null;
        if (arr2 == null) {
            Arrays.sort(arr1);
            return arr1;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(arr2[i], 0);
        }
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }
        int index = 0;
        for (int i = 0; i < len2; i++) {
            int time = map.get(arr2[i]);
            while (time > 0) {
                res[index++] = arr2[i];
                time--;
            }
        }
        int sort = index;
        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(arr1[i])) {
                res[index++] = arr1[i];
            }
        }
        Arrays.sort(res, sort, len1);
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        int[] res = relativeSortArray(arr1, arr2);
    }
}
