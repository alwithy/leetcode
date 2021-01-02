import java.util.HashMap;

public class Q0421_MaxXOR {
    //前缀树
    static class Node {
        HashMap<Integer, Node> children;

        public Node() {
            children = new HashMap<>();
        }
    }

    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int L = Integer.toBinaryString(max).length();
        int highest = 1 << L;
        Node root = new Node();
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            //将所有数字的二进制字符串补齐到L位
            String s = Integer.toBinaryString(num | highest).substring(1);
            Node curNode = root, xorNode = root;

            //将数字插入字典树
            for (int i = 0; i < s.length(); i++) {
                int bit = s.charAt(i) - '0';
                if (!curNode.children.containsKey(bit)) {
                    curNode.children.put(bit, new Node());
                }
                curNode = curNode.children.get(bit);
            }

            //当前数字的最大异或值
            int curXOR = 0;
            for (int i = 0; i < s.length(); i++) {
                int bit = s.charAt(i) - '0';
                int need = 1 ^ bit;
                if (xorNode.children.containsKey(need)) {
                    curXOR = (curXOR << 1) | 1;
                    xorNode = xorNode.children.get(need);
                } else {
                    curXOR = curXOR << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            res = Math.max(res, curXOR);
        }

        return res;
    }
}
