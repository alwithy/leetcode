public class Q0260_SingleNumber {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        //找到xor二进制中任意一个1
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                xor = 1 << i;
                break;
            }
        }

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & xor) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
