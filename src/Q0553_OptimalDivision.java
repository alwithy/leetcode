public class Q0553_OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        // 把从第二个数字到最后一个数字括起来
        StringBuilder res = new StringBuilder().append(nums[0]).append("/(");
        for (int i = 1; i < nums.length; i++) {
            res.append(nums[i]).append("/");
        }
        res.deleteCharAt(res.length() - 1);
        res.append(")");
        return res.toString();
    }
}
