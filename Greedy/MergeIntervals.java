import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {9,18}
        };

        MergeIntervals mi = new MergeIntervals();
        System.out.println(mi.merge(intervals));

    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2) -> Integer.compare(o1[0],o2[0]));
        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > intervals[i - 1][1]) {
                int[] cur = {start,intervals[i - 1][1]};
                res.add(cur);
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});

        return res.toArray(new int[res.size()][]);
    }
}
