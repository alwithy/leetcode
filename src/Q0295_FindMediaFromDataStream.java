import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0295_FindMediaFromDataStream {
    class MedianFinder {
        private PriorityQueue<Integer> big;//存放较大数的小根堆
        private PriorityQueue<Integer> small;//存放较小数的大根堆

        /** initialize your data structure here. */
        public MedianFinder() {
            big = new PriorityQueue<>();
            small = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            //添加数字
            if (!big.isEmpty() && !small.isEmpty()) {
                if (num > small.peek()) {
                    big.add(num);
                } else {
                    small.add(num);
                }
            } else if (!big.isEmpty()) {
                if (num >= big.peek()) {
                    big.add(num);
                } else {
                    small.add(num);
                }
            } else if (!small.isEmpty()) {
                if (num <= small.peek()) {
                    small.add(num);
                } else {
                    big.add(num);
                }
            } else {
                small.add(num);
            }

            //调整small和big，使它们size之差不大于1
            while (Math.abs(big.size() - small.size()) > 1) {
                if (big.size() > small.size()) {
                    small.add(big.poll());
                } else {
                    big.add(small.poll());
                }
            }
        }

        public double findMedian() {
            if (big.isEmpty() && small.isEmpty()) {
                return 0d;
            }

            if (big.isEmpty()) {//说明此时只有一个数字
                return (double)small.peek();
            }

            if (big.size() > small.size()) {
                return (double)big.peek();
            } else if (small.size() > big.size()) {
                return (double)small.peek();
            } else {
                return ((double)big.peek() + small.peek())/2;
            }
        }
    }
}
