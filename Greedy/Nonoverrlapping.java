import java.util.Arrays;

public class Nonoverrlapping {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {2,3},
        };

        Nonoverrlapping nol = new Nonoverrlapping();
        System.out.println(nol.eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2) -> Integer.compare(o1[0],o2[0]));

        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i][1],intervals[i -1][1]);
                count++;
            }
        }
        return count;
    }
}
