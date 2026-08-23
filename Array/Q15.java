import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int start = i + 1;
            int last = nums.length - 1;
            while (start < last) {
                long sum = (long)nums[start] + nums[last] + nums[i];
                if (sum == 0) {
                    List<Integer> obj = new ArrayList<>();
                    obj.add(nums[i]);
                    obj.add(nums[start]);
                    obj.add(nums[last]);
                    ans.add(obj);
                    start++;
                    last--;
                    while (start < last && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < last && nums[last] == nums[last + 1]) {
                        last--;
                    }
                } else if (sum > 0) {
                    last--;
                } else {
                    start++;
                }
            }
            i++;
        }
        return ans;
    }
}
