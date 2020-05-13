import java.util.ArrayList;
import java.util.List;

public class Q0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // left，right代表当前区间的左右边界
        int left = 0;
        int right = 0;
        int i = 0;
        while (i < nums.length) {
            left = i;
            right = i;
            while ( right + 1 < nums.length
                    && nums[right + 1] == nums[right] + 1) {
                right++;
            }
            if (right > left) {
                res.add(String.valueOf(nums[left]) + "->" +
                        String.valueOf(nums[right]));
                i = right + 1;
            } else {
                res.add(String.valueOf(nums[i]));
                i++;
            }
        }

        return res;
    }
}
