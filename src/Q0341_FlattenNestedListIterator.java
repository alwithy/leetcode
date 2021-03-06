import java.util.*;

public class Q0341_FlattenNestedListIterator {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {
        //指向下一个应该访问的元素
        private int index;
        //存放所有的元素
        private List<Integer> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            index = 0;
            list = new ArrayList<>();
            buildList(nestedList, list);
        }

        private void buildList(List<NestedInteger> nestedList, List<Integer> list) {
            NestedInteger node;
            for (int i = 0; i < nestedList.size(); i++) {
                node = nestedList.get(i);
                if (node.isInteger()) {
                    list.add(node.getInteger());
                } else {
                    buildList(node.getList(), list);
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }
}
