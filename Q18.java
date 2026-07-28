import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> mainpair = new ArrayList<>();
        while (i < nums.length) {
            if (i > 0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            int j = i+1;
            while (j < nums.length) {
                if (j > i+1 && nums[j] == nums[j -1]){
                    j++;
                    continue;
                }
                int start = j + 1;
                int last = nums.length - 1;
                while (start < last) {
                    List<Integer> pair = new ArrayList<>();
                    int sum = nums[i] + nums[start] + nums[last] + nums[j];
                    if (sum < target) {
                        start++;
                    } else if (sum > target) {
                        last--;
                    } else {
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        pair.add(nums[start]);
                        pair.add(nums[last]);
                        mainpair.add(pair);
                        start++;
                        last--;
                        while(start < last && nums[start] == nums[start -1]){
                            start++;
                        };
                        while(start < last && nums[last] == nums[last +1]){
                            last--;
                        };

                        
                    }
                }
                j++;
            }
            i++;
        }
        return mainpair;
    }
    

    public static void main(String[] args) {
        Q18 val = new Q18();
        int[] nums = {1,0,-1,0,-2,2 };
        System.out.println(val.fourSum(nums, 0));
    }
}