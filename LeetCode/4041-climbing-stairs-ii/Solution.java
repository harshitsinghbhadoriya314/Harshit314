class Solution {
    public int climbStairs(int n, int[] costs) {
        int [] dp = new int [costs.length + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int k = i+1; k <= Math.min(n , i+3);k++){
                int cost = dp[i] + costs[k-1] + (int)Math.pow((k-i),2);
                dp[k] = Math.min(dp[k], cost);
            }
        }
        return dp[n];
    }
}