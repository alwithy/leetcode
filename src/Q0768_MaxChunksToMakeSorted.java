import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0768_MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
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
            if (!minHeap.isEmpty() && minHeap.peek() >= maxHeap.peek()) {
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
        int[] max=new int[arr.length];
        max[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            max[i]=Math.max(arr[i],max[i-1]);
        }
        int min=Integer.MAX_VALUE;
        int result=0;
        for(int i=arr.length-1;i>=0;i--){
            if(min>=max[i]){
                result++;
            }
            min=Math.min(arr[i],min);
        }
        return result;
    }
}
