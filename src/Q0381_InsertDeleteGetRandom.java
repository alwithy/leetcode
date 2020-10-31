import java.util.*;

public class Q0381_InsertDeleteGetRandom {
    static class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> nums;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new HashMap<>();
            list = new LinkedList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res;
            list.add(val);
            if (nums.containsKey(val)) {
                res = false;
                nums.get(val).add(list.size() - 1);
            } else {
                res = true;
                HashSet set = new HashSet<>();
                set.add(list.size() - 1);
                nums.put(val, set);
            }

            return res;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!nums.containsKey(val)) return false;
            Iterator<Integer> it = nums.get(val).iterator();
            int i = it.next();
            nums.get(val).remove(i);
            if (i < list.size() - 1) {
                int lastNum = list.get(list.size() - 1);
                HashSet<Integer> lastSet = nums.get(lastNum);
                lastSet.remove(list.size() - 1);
                lastSet.add(i);
                list.set(i, lastNum);
            }
            list.remove(list.size() - 1);
            if (nums.get(val).size() == 0) nums.remove(val);

            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(0);
        rc.remove(0);
        rc.remove(0);
    }
}
