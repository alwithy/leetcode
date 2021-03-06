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
            //buildList(nestedList, list);

            //非递归构建
            NestedInteger node;
            int index;
            Deque<Integer> indexes = new LinkedList<>();
            Deque<NestedInteger> nodes = new LinkedList<>();
            for (int i = 0; i < nestedList.size(); i++) {
                indexes.addLast(0);
                nodes.addLast(nestedList.get(i));

                while (!nodes.isEmpty()) {
                    node = nodes.pollLast();
                    index = indexes.pollLast();

                    //是整数则直接加进列表
                    if (node.isInteger()) {
                        list.add(node.getInteger());
                        continue;
                    }

                    //不是整数则判断当前应该访问的位置是否已经到列表末尾
                    List<NestedInteger> list = node.getList();
                    if (index == list.size()) {
                        continue;
                    }

                    //还没到末尾时
                    nodes.addLast(node);
                    indexes.addLast(index + 1);

                    nodes.addLast(list.get(index));
                    indexes.addLast(0);
                }
            }
        }

        //递归构建
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
