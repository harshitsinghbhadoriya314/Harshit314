import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 1;
        int last = nums.length-1;
        int temp = nums[start-1];
        int sum = 0;
        int smalldiff = nums.length;
        while (start < last){
            if (target > nums.length){
                
            }
            sum = temp + nums[start] + nums[last];
            int diff = Math.abs(target - sum);
            if (diff <= smalldiff){
                smalldiff = diff;
                start++;
                temp = nums[start-1];
            }
        }
        return sum;
    }
    public static void main(String[] args){
      Solution sol = new Solution();
      int [] nums = {-1, 2, 1, -4};
      System.out.println(sol.threeSumClosest(nums, 1));
    }
}