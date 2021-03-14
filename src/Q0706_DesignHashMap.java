public class Q0706_DesignHashMap {
    static class MyHashMap {
        private int[] map;
        private boolean[] keySet;

        /** Initialize your data structure here. */
        public MyHashMap() {
            map = new int[1000_001];
            keySet = new boolean[1000_001];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            keySet[key] = true;
            map[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return keySet[key] ? map[key] : -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            keySet[key] = false;
        }
    }
}
