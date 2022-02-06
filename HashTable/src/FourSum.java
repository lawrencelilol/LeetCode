import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);

        for (List<Integer> l: ans) {
            System.out.println("---------");
            for(int i : l) {
                System.out.println(i);
            }
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while(right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum > target) {
                        right--;
                    } else if(sum < target) {
                        left++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while(right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while(right > left  && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left ++;
                        right --;
                    }
                }
            }
        }
        return res;
    }
}
