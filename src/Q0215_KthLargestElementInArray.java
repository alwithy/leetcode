import java.util.PriorityQueue;

public class Q0215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }
}
