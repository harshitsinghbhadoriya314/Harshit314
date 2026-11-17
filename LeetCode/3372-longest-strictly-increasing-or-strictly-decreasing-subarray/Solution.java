class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int in = 0;
        int de = 0;
        int s1 = 0;
        int s2 = 0;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] < nums[i + 1]) {
                s2 = i + 1;
                in = Math.max(in, i + 2 - s1);
                ans = Math.max(ans, in);
            } else if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                s1 = i + 1;
                de = Math.max(de,i + 2 - s2);
                ans = Math.max(de, ans);
            } else {
                s1 = i + 1;
                s2 = i + 1;
                de = 0;
                in = 0;
            }
        }

        return ans;
    }
}