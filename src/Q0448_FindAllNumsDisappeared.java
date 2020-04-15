import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0448_FindAllNumsDisappeared {
    //方法一，访问过的数字标记为负
    public static List<Integer> findDisappearedNums1(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    //访问过的数字增加length
    public static List<Integer> findDisappearedNums2(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
