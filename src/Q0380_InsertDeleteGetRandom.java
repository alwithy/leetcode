import java.util.*;

public class Q0380_InsertDeleteGetRandom {
    class RandomizedSet {
        private HashMap<Integer,Integer> valueIndex;
        private List<Integer> list;
        private Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.valueIndex = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valueIndex.containsKey(val)) {
                return false;
            } else {
                list.add(val);
                valueIndex.put(val, list.size() - 1);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!valueIndex.containsKey(val)) {
                return false;
            } else {
                //交换要删除的元素和最后一个元素
                int temp = list.get(list.size() - 1);
                list.set(list.size() - 1, list.get(valueIndex.get(val)));
                list.set(valueIndex.get(val), temp);
                //改变原本最后一个元素的索引
                valueIndex.put(temp, valueIndex.get(val));
                //删除最后一个元素
                list.remove(list.size() - 1);
                valueIndex.remove(val);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
