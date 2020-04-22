public class Q0027_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int diff = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == val) {
                j++;
                diff++;
            }
            if (j < nums.length) {
                nums[i++] = nums[j++];
            }
        }
        return nums.length - diff;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(
                removeElement(arr,2));
    }
}
