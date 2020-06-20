import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0539_MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        // 排序后遍历
        // 空间O(n),时间O(n * log n)
        String[] times = new String[timePoints.size()];
        for (int i = 0; i < times.length; i++) {
            times[i] = timePoints.get(i);
        }
        Arrays.sort(times, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int aHour = (a.charAt(0) - '0') * 10 + a.charAt(1) - '0';
                int bHour = (b.charAt(0) - '0') * 10 + b.charAt(1) - '0';
                if (aHour != bHour) {
                    return aHour - bHour;
                } else {
                    return (a.charAt(3) - '0') * 10 + a.charAt(4) - '0'
                            - ((b.charAt(3) - '0') * 10 + b.charAt(4) - '0');
                }
            }
        });

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            res = Math.min(res, getDiff(times[i - 1], times[i]));
        }
        res = Math.min(res, getDiff(times[0], times[times.length - 1]));

        return res;
    }

    private static int getDiff(String a, String b) {
        // 时间b比时间a靠后
        int aHour = (a.charAt(0) - '0') * 10 + a.charAt(1) - '0';
        int aMin = (a.charAt(3) - '0') * 10 + a.charAt(4) - '0';
        int bHour = (b.charAt(0) - '0') * 10 + b.charAt(1) - '0';
        int bMin = (b.charAt(3) - '0') * 10 + b.charAt(4) - '0';
        int diffOfHour;
        if (bHour - aHour > aHour + 24 - bHour) {
            diffOfHour = aHour + 24 - bHour;
            if (aMin < bMin) {
                return (diffOfHour - 1) * 60 + aMin + 60 - bMin;
            } else {
                return diffOfHour * 60 + aMin - bMin;
            }
        } else {
            diffOfHour = bHour - aHour;
            if (bMin < aMin) {
                return (diffOfHour - 1) * 60 + bMin - aMin + 60;
            } else {
                return diffOfHour * 60 + bMin - aMin;
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        System.out.println(findMinDifference(list));
    }
}
