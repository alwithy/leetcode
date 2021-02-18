import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q0313_SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int m = primes.length;
        int[] indexes = new int[m];
        //小根堆
        //arr[0]为实际值，arr[1]为之前乘上的质因数在primes中的索引
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[0];
                Integer b = o2[0];
                return a.compareTo(b);
            }
        });
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{primes[i], i});
        }

        while (list.size() < n) {
            int[] arr = queue.poll();
            if (arr[0] > list.get(list.size() - 1)) {
                list.add(arr[0]);
            }
            indexes[arr[1]]++;
            arr[0] = list.get(indexes[arr[1]]) * primes[arr[1]];
            queue.add(arr);
        }

        return list.get(n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2,7,13,19};
        int n = 32;
        System.out.println(nthSuperUglyNumber(n, arr));
    }
}
