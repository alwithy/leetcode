import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q0284_PeekingIterator {
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;
        List<Integer> list;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            this.list = new ArrayList<>();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            Integer res = null;
            if (list.size() > 0) {
                res = list.get(0);
            } else if (iterator.hasNext()) {
                res = iterator.next();
                list.add(res);
            }
            return res;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = null;
            if (list.size() > 0) {
                res = list.get(0);
                list.remove(0);
            } else if (iterator.hasNext()){
                res = iterator.next();
            }

            return res;
        }

        @Override
        public boolean hasNext() {
            return list.size() > 0 || iterator.hasNext();
        }
    }
}
