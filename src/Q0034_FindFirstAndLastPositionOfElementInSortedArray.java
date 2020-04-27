public class Q0034_FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length < 1
        || nums[0] > target || nums[nums.length - 1] < target) {
            return res;
        }
        //两次二分查找，首先查找首次出现的索引
        int l = 0;
        int r = nums.length - 1;
        int mid;
        if (nums[l] != target) {
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {//nums[mid] == target
                    r = mid;
                }
            }
        }

        if (nums[l] != target) {
            return res;
        }
        res[0] = l;

        //查找最后一次出现的索引
        r = nums.length - 1;
        if (nums[r] == target) {
            res[1] = r;
        } else {
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] > target) {
                    r = mid - 1;
                   if (nums[r] == target
                           && r < nums.length - 1
                           && nums[r + 1] > target) {
                       l = r;
                       break;
                   }
                } else {//nums[mid] == target
                    l = mid;
                    if (nums[mid + 1] != target) {
                        break;
                    }
                }
            }
            res[1] = l;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,2};
        int[] res = searchRange(arr,0);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
