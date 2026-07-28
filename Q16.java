import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int initial_sum = nums[0] + nums[1] + nums[2];
        int initial_diff = Math.abs(target - initial_sum);
        while (i < nums.length) {
            int start = i + 1;
            int last = nums.length - 1;
            while (start < last) {
                int sum = nums[i] + nums[start] + nums[last];
                int diff = Math.abs(target - sum);
                if (diff < initial_diff) {
                    initial_diff = diff;
                    initial_sum = sum;
                }

                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    last--;
                } else {
                    return sum;
                }
            }
            i++;
        }
        return initial_sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { -1, 2, 1, -4 };
        System.out.println(sol.threeSumClosest(nums, 1));
    }
}