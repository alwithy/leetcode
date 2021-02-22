public class Q1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //滑动窗口法
        int n = customers.length;
        int sum = 0;//本身就满意的人的数量
        int curChange = 0;//原本不满意，老板使用技巧后满意的人的数量
        int maxChange = 0;
        for (int i = 0; i < n; i++) {
            if (i - X >= 0 && grumpy[i - X] == 1) {
                curChange -= customers[i - X];
            }
            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                curChange += customers[i];
            }
            maxChange = Math.max(maxChange, curChange);
        }

        return sum + maxChange;
    }
}
