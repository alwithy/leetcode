import java.util.ArrayList;
import java.util.List;

public class Q0229_MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 使用摩尔投票法
        // 初始化两个候选人
        int cand1 = nums[0];
        int count1 = 0;
        int cand2 = nums[0];
        int count2 = 0;

        for (int num : nums) {
            // 匹配第一个候选人
            if (num == cand1) {
                count1++;
                continue;
            }

            // 匹配第二个候选人
            if (num == cand2) {
                count2++;
                continue;
            }

            // 更换第一个候选人
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }

            // 更换第二个候选人
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        // 此时的cand1和cand2有可能是结果
        // 再遍历一次确认
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
                continue;
            }
            if (num == cand2) {
                count2++;
            }
        }

        if (count1 > nums.length/3) {
            res.add(cand1);
        }

        if (count2 > nums.length/3) {
            res.add(cand2);
        }

        return res;
    }
}
