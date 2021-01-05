public class Q0137_SingleNumber {
    public int singleNumber(int[] nums) {
        //官方题解3
        //出现一次的位和出现两次的位
        int once = 0, twice = 0;

        for (int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }

        return once;
    }
}
