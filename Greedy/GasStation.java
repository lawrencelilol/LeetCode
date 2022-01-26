public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int rest = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            rest += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if(rest < 0) {
                start = i + 1;
                rest = 0;
            }
        }

        if(totalSum < 0) {
            return -1;
        }

        return start;
    }
}
