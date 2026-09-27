class Solution {
    public int numDistinct(String s, String t){
        int i = 0; int j = 0;
        int [][] dp = new int [s.length()][t.length()];
        for(int k = 0; k < s.length(); k++){
            Arrays.fill(dp[k], -1);
        }
        int Count = solve(i, j, s, t, dp);
        return Count;
    }
    public int solve(int i , int j, String s, String t, int [][] dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = solve(i+1, j+1, s, t, dp) + solve(i+1, j, s, t, dp);
            return dp[i][j];
        }
        dp[i][j] = solve(i+1,j, s, t, dp);
        return dp[i][j];
    }
    public int distinctSubseqII(String s) {
        long ok = (long) Math.pow(10, 9) + 7;
        long[] last = new long[26];
        long total = 1;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            long old = total;

            total = 2 * total - last[index];
            total = total + ok;
            total = total % ok;
            last[index] = old;
        }
        return (int) ((total - 1 + ok) % ok);
    }
}