import java.util.PriorityQueue;

public class Q0703_KthLargestElementInStream {
    static class KthLargest {
        private int k;
        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }
        }

        public int add(int val) {
            queue.add(val);
            while (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));
        System.out.println(kl.add(9));
        System.out.println(kl.add(4));
    }
}
