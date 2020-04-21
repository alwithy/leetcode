import java.util.ArrayList;
import java.util.HashMap;

public class Q0729_MyCalendar {
    static class MyCalendar {
        private HashMap<Integer,Integer> map;//记录start,end键值对
        private ArrayList<Integer> starts;//记录开始时间的链表

        public MyCalendar() {
            map = new HashMap<>();
            starts = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            if (map.containsKey(start)) {
                return false;
            }
            if (starts.isEmpty()) {
                starts.add(start);
                map.put(start,end);
                return true;
            }
            boolean res = false;
            //i表示插入位置
            int i = 0;
//            for (; i < starts.size(); i++) {
//                if (start < starts.get(i)) {
//                    break;
//                }
//            }
            if (start < starts.get(0)) {
                if (end <= starts.get(0)) {
                    res = true;
                    i = 0;
                }
            } else if (start > starts.get(starts.size() - 1)) {
                if (start >= map.get(starts.get(starts.size() - 1))) {
                    i = starts.size();
                    res = true;
                }
            } else {
                //此处情况指的是按开始时间排序，新事件既不是第一个也不是最后一个
                //二分查找
                int l = 0;
                int r = starts.size() - 1;
                int mid;
                while (r > l) {
                    mid = l + ((r - l) >> 1);
                    if (starts.get(mid) < start) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                i = l;
                if (end <= starts.get(i)
                        && start >= map.get(starts.get(i - 1))) {
                    res = true;
                }
            }

            if (res) {
                starts.add(i, start);
                map.put(start,end);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10,20));
        System.out.println(myCalendar.book(15,25));
        System.out.println(
                myCalendar.book(20,30));
        //System.out.println(myCalendar.book(4,5));
    }
}
