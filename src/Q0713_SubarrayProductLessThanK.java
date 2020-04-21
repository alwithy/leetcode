public class Q0713_SubarrayProductLessThanK {
    //时间空间均为O(n)
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        //申请数组
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        //length[i]记录以nums[i]开头的乘积小于k的最长子数组的长度
        int[] length = new int[nums.length];
        //count记录子数组的总数量
        int count = 0;
        //product记录上一个最长子数组的积
        int product = 0;
        //首先确定length[0]
        if (nums[0] >= k) {
            length[0] = 0;
        } else {
            product = nums[0];
            int i = 1;
            for (; i < nums.length; i++) {
                if (product * nums[i] >= k) {
                    break;
                } else {
                    product *= nums[i];
                }
            }
            length[0] = i;
            count += length[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if (length[i - 1] >= 2) {
                product /= nums[i - 1];
                int j = i - 1 + length[i - 1];
                for (; j < nums.length; j++) {
                    if (product * nums[j] >= k) {
                        break;
                    } else {
                        product *= nums[j];
                    }
                }
                length[i] = j - i;
                count += length[i];
            } else if (nums[i] >= k) {
                length[i] = 0;
            } else {//nums[i] < k的情况
                product = nums[i];
                int j = i + 1;
                for (; j < nums.length; j++) {
                    if (product * nums[j] >= k) {
                        break;
                    } else {
                        product *= nums[j];
                    }
                }
                length[i] = j - i;
                count += length[i];
            }
        }
        return count;
    }

    //时间O(n),空间O(1)
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }
        int product = 1;
        int right = 0;
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            if (right > left) {
                if (left > 0) {
                    product /= nums[left - 1];
                }
                for (; right < nums.length; right++) {
                    if (product * nums[right] >= k) {
                        break;
                    } else {
                        product *= nums[right];
                    }
                }
                count += right - left;
            } else if (nums[left] < k) {
                product = nums[left];
                right = left + 1;
                for (; right < nums.length; right++) {
                    if (product * nums[right] >= k) {
                        break;
                    } else {
                        product *= nums[right];
                    }
                }
                count += right - left;
            }//还剩一种nums[k] >= k，此时直接continue
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK2(arr,100));
    }
}
