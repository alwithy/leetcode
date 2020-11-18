public class Q0134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length || cost.length == 0) {
            return -1;
        }
        int i = 0;
        int len = gas.length;
        while (i < len) {
            int gasSum = 0, costSum = 0, move = 0;
            while (move < len) {
                int j = (i + move) % len;
                gasSum += gas[j];
                costSum += cost[j];
                if (gasSum < costSum) {
                    break;
                }
                move++;
            }
            if (move == len) {
                return i;
            } else {
                i += move + 1;
            }
        }

        return -1;
    }
}
