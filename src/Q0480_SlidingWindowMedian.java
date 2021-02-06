import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q0480_SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len - k + 1];
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        res[0] = dh.getMedian();
        for (int i = k; i < len; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            res[i - k + 1] = dh.getMedian();
        }

        return res;
    }

    static class DualHeap {
        //大根堆，存放较小的一半元素
        private PriorityQueue<Integer> small;
        //小根堆，存放较大的一半元素
        private PriorityQueue<Integer> big;
        //需要延迟删除的元素,key为删除的元素，value为删除次数
        private HashMap<Integer, Integer> delayed;
        private int k;
        //small和big中除去需要延迟删除的元素后的数量
        private int bigSize, smallSize;

        public DualHeap(int k) {
            small = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            big = new PriorityQueue<>();
            delayed = new HashMap<>();
            this.k = k;
            bigSize = 0;
            smallSize = 0;
        }

        //取中位数
        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double)small.peek() + big.peek())/2;
        }

        //插入元素
        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.add(num);
                smallSize++;
            } else {
                big.add(num);
                bigSize++;
            }
            makeBalance();
        }

        //删除元素
        public void erase(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                bigSize--;
                if (num == big.peek()) {
                    prune(big);
                }
            }
            makeBalance();
        }

        //弹出堆顶元素并更新哈希表
        //保证堆顶元素是不需要被删除的
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    heap.poll();
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                } else {
                    break;
                }
            }
        }

        //平衡两个heap的size
        //保证small的元素比big多一个或者与big相等
        private void makeBalance() {
            if (smallSize > bigSize + 1) {
                big.add(small.poll());
                prune(small);
                smallSize--;
                bigSize++;
            } else if (smallSize < bigSize) {
                small.add(big.poll());
                prune(big);
                smallSize++;
                bigSize--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;
        int max = Integer.MAX_VALUE;
        double[] res = medianSlidingWindow(nums, k);
    }
}
