import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels(s));
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();

        int[]edges = new int[26];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edges[chars[i] - 'a'] = i;
        }

        int idx = 0;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edges[chars[i] - 'a']);
            last++;
            if( i == idx) {
                list.add(last);
                last = 0;
            }
        }
        return list;
    }
}
