public class Q0307_RangeSumQuery {

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */
    static class NumArray {
        //官方题解2，sqrt分解
        private int[] b;
        private int len;
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            double l = Math.sqrt(nums.length);
            this.len = (int) Math.ceil(nums.length / l);
            this.b = new int[len];
            for (int i = 0; i < nums.length; i++) {
                b[i / len] += nums[i];
            }
        }

        public void update(int i, int val) {
            int index = i / len;
            b[index] = b[index] - nums[i] + val;
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int res = 0;
            while (i <= j && i % len != 0) {
                res += nums[i];
                i++;
            }

            while (i + len - 1 <= j) {
                res += b[i / len];
                i += len;
            }

            while (i <= j) {
                res += nums[i];
                i++;
            }
            return res;
        }
    }
}
