public class Q5654_MaximumNumberOfBallsInBox {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            boxes[count(i)]++;
        }
        int res = 0;
        for (int box : boxes) {
            res = Math.max(box, res);
        }
        return res;
    }

    public int count(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}
