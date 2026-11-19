class Solution {
    public int minimizeSum(int[] nums) {
        // three case 
        Arrays.sort(nums);
        int n = nums.length;
        if (n >= 3){
           int ans = Math.min(check(nums, 0, 1), check(nums, n - 2, n - 1));
           return Math.min(ans, check(nums, 0, n - 1));
        }
        return 0;
    }

    int check(int[] nums, int v1, int v2) {
        if (Math.abs(v2 - v1) == 1) {
            if (v1 - 1 < 0) {
                return Math.abs(nums[nums.length-1] - nums[v2 + 1]);
            }
            else if (v2 + 1 == nums.length){
                return Math.abs(nums[0] - nums[v1-1]);
            }
        }
        return Math.abs(nums[v2 - 1] - nums[v1 + 1]);
    }
}