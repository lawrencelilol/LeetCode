import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return res;
            }

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(right > left) {

                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    left ++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);

                    while(right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
