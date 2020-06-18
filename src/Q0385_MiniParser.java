public class Q0385_MiniParser {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

//    class Solution {
//        int cur;
//
//        public NestedInteger deserialize(String s) {
//            if (s == null || s.length() == 0) return new NestedInteger();
//            if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
//            // 递归解决
//            cur = 1;
//
//            return get(s);
//        }
//
//        private NestedInteger get(String s) {
//            NestedInteger res = new NestedInteger();
//            char c;
//            int isPositive = 1;
//            for (; cur < s.length(); cur++) {
//                c = s.charAt(cur);
//                if (c == ',') continue;
//                if (c == '[') {
//                    cur++;
//                    res.add(get(s));
//                    continue;
//                }
//                if (c == ']') return res;
//                if (c == '-') {
//                    isPositive = -1;
//                } else {
//                    // 是数字的情况
//                    int num = c - '0';
//                    while (cur + 1 < s.length() && Character.isDigit(s.charAt(cur + 1))) {
//                        cur++;
//                        num = num * 10 + (s.charAt(cur) - '0');
//                    }
//                    num = num * isPositive;
//                    res.add(new NestedInteger(num));
//                    isPositive = 1;
//                }
//            }
//            return null;
//        }
//    }
}
