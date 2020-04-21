import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0769_MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        //遍历数组，将数组划分为左右两块
        //当左块最大值小于右块最小值，则可以划分为两块
        //左侧用大根堆，右侧用小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            minHeap.remove(arr[i]);
            if (!minHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                res++;
                maxHeap = new PriorityQueue<>(new MyComparator());
            }
        }
        return res;
    }


    //实现大根堆的比较器
    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    public int maxChunksToSorted2(int[] arr) {

        if(arr ==null){
            return 0;
        }
        int ret = 0;
        int max =arr[0];
        for(int i=0;i< arr.length;i++){
            max = Math.max(max,arr[i]);
            //当max != i时，说明arr从0号到i号元素中一定少了数字{0,1...,i}中的某一个
            //这个少掉的数字在arr的第i+1号元素到最后一个元素之中
            //此时左块的最大值一定大于右块的最小值，所以不能划分
            if(max==i){
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        System.out.println(maxChunksToSorted(arr));
    }
}
