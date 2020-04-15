import java.util.ArrayList;
import java.util.List;

public class Q0442_FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        //遇到一次的数字就标为负数
        //如果在标记的过程中发现已经是负数，则添加到res中
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                nums[index] *= -1;
                res.add(index + 1);
            } else {
                nums[index] *= -1;
            }
        }
        return res;
    }
}
