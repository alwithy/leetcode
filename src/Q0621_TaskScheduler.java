import java.util.Arrays;

public class Q0621_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
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
        System.out.println(leastInterval(arr,2));
    }
}
