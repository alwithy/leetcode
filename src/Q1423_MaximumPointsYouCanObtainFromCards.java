public class Q1423_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        //滑动窗口，等效于求长度为len - k的连续窗口的最小值
        int len = cardPoints.length;
        int sum = 0;
        for (int num : cardPoints) {
            sum += num;
        }
        if (k == len) {
            return sum;
        }
        int curSum = 0;
        for (int i = 0; i < len - k; i++) {
            curSum += cardPoints[i];
        }
        int res = sum - curSum;
        for (int i = len - k; i < len; i++) {
            curSum = curSum - cardPoints[i - len + k] + cardPoints[i];
            res = Math.max(res, sum - curSum);
        }
        return res;
    }
}
