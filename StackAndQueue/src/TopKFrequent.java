import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,3};
        int k = 3;

        TopKFrequent tkf = new TopKFrequent();
        int[] ans = tkf.topKFrequent(nums,k);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = k -1; i >=0 ; i--) {
            res[i] = pq.poll().getKey();
        }

        return res;

    }

}
