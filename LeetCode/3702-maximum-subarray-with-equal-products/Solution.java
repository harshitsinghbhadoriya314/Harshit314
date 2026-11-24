class Solution {
    public int maxLength(int[] nums) {
        int start = 0;
        int len = 0;
        while (start < nums.length) {
            int pr = nums[start];
            int gcd = nums[start];
            int lcm = nums[start];
            int last = start + 1;
            while (last < nums.length) {
                    gcd = gcdof(gcd, nums[last]);
                    pr = pr * nums[last];
                    lcm = lcm * nums[last] / gcdof(lcm, nums[last]);
                    if (lcm * gcd == pr) {
                        len = Math.max(len, (int) Math.abs(last - start) + 1);
                    }
                    last++;
                }
            start++;
        }
        return len;
    }

    int gcdof(int gcd, int n) {
        while (n != 0) {
            if (gcd == 1 || n == 1) {
                return 1;
            }
            int temp = n;
            n = gcd % n;
            gcd = temp;
        }
        return gcd;
    }

    int lcmof(int lcm, int prev) {
        return lcm * prev;
    }
}