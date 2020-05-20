import oracle.jrockit.jfr.settings.PresetFile;

public class Q0042_TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length < 3) {
            return res;
        }

        // 以height[0]为起点，寻找到第一个高度大于等于height[0]的柱子
        // 计算两个柱子之间的容积，以此类推
        // 单向找会有遗漏，所以我们从左向右找一次，再从右向左找一次
        // 重复计算的部分为左右柱子高度相等，去掉就行
        int left = 0;
        int right,capacity;
        // 从左向右找，包含左右柱子高度相等的部分
        while (left < height.length) {
            // 首先找到一个高度大于0的左柱子
            if (height[left] == 0) {
                left++;
                continue;
            }

            // 然后找一个高度不小于左柱子的右柱子
            right = left + 1;
            while (right < height.length
                    && height[right] < height[left]) {
                right++;
            }

            if (right >= height.length) {
                break;
            }

            // 计算这部分的容积
            capacity = 0;
            for (int i = left + 1; i < right; i++) {
                capacity += height[left] - height[i];
            }

            res += capacity;
            left = right;
        }

        // 从右向左找，不包括左右柱子高度相等的部分
        right = height.length - 1;
        while (right >= 0) {
            // 找右柱子
            if (height[right] == 0) {
                right--;
                continue;
            }

            // 找高度大于右柱子的左柱子
            left = right - 1;
            while (left >= 0
                    && height[left] <= height[right]) {
                left--;
            }

            if (left < 0) {
                break;
            }

            // 计算这部分容积
            capacity = 0;
            for (int i = right - 1; i > left ; i--) {
                capacity += height[right] - height[i];
            }

            res += capacity;
            right = left;
        }

        return res;
    }
}
