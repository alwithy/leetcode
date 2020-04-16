import java.util.LinkedList;
import java.util.Queue;

public class Q0649_Dota2Senate {
    public static String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList<>();
        int[] people = {0, 0};
        int[] bans = {0, 0};//bans[0]代表R方被禁的次数

        for (char i : senate.toCharArray()) {
            int x = i == 'R' ? 0 : 1;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x ^ 1]++;
                queue.add(x);
            }
        }

        return people[0] > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        String arr = "DDRRR";
        System.out.println(predictPartyVictory(arr));
    }
}
