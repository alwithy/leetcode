import java.util.Arrays;

public class Q0825_FriendsOfAppropriateAges {
    public static int numFriendRequests1(int[] ages) {
        if (ages == null || ages.length < 1) {
            return 0;
        }
        Arrays.sort(ages);
        int res = 0;
        //last保存上一个ages[i]能发送的好友请求数量
        int last = 0;
        int j = ages.length - 1;
        for (int i = ages.length - 1; i >= 0; i--) {
            if (ages[i] <= 14) {
                break;
            }
            if (i + 1 < ages.length && ages[i] == ages[i + 1]) {
                res += last;
            } else {
                while (j >= 0
                        && ages[j] > 0.5 * ages[i] + 7) {
                    j--;
                }
                last = i - j - 1;
                if (ages[0] > 0.5 * ages[i] + 7) {
                    last++;
                }
                if (last > 0) {
                    res += last;
                }
            }
        }
        return res;
    }

    //注意到年龄的范围是[1,120]
    public int numFriendRequests2(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 15; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 15; ageB <= ageA; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ages = {14,14};
        System.out.println(
                        numFriendRequests1(ages));
    }
}
