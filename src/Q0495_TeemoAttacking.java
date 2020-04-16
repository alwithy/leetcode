public class Q0495_TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length <= 0 || duration == 0) {
            return 0;
        }
        //time记录中毒时长
        int time = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                time += duration;
            } else {
                time += timeSeries[i] - timeSeries[i - 1];
            }
        }
        //增加上最后一次中毒的持续时间
        return time + duration;
    }
}
