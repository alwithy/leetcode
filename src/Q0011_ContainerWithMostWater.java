public class Q0011_ContainerWithMostWater {
    //暴力法
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                cur = (Math.min(height[i], height[j])) * (j - i);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    //双指针法
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        //max为最大容积
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max,
                    (Math.min(height[l], height[r])) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
