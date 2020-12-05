import java.util.Arrays;

public class Q0621_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        //官方题解2
        int[] chs = new int[26];
        //max记录任务的最多执行次数
        int max = 0;
        for (int i = 0; i < tasks.length; i++) {
            int c = tasks[i] - 'A';
            chs[c]++;
            max = Math.max(max, chs[c]);
        }

        int maxCount = 0;
        for (int c : chs) {
            if (c == max) {
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static int leastInterval1(char[] tasks, int n) {
        int[] taskNum = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            taskNum[tasks[i] - 'A']++;
        }
        Arrays.sort(taskNum);
        int i;
        int time = 0;
        while (taskNum[25] > 0) {
            //每轮做n + 1种任务，任务种类不够则空过
            i = 0;
            while (i < 26 && i <= n && taskNum[25 - i] > 0) {
                taskNum[25 - i]--;
                i++;
                time++;
            }
            Arrays.sort(taskNum);
            if (taskNum[25] == 0) {
                break;
            }
            //空过的时间
            while (i <= n) {
                i++;
                time++;
            }

        }
        return time;
    }

    public static void main(String[] args) {
        char[] arr = {'A','A','B','B','C','C',
                'D','D','E','E','F','F',
                'G','G','H','H','I','I',
                'J','J','K','K','L','L',
                'M','M','N','N','O','O',
                'P','P','Q','Q','R','R'};
//        arr = new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        System.out.println(leastInterval1(arr,2));
        System.out.println(leastInterval(arr,2));
    }
}
