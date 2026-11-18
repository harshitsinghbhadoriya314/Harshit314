class Solution {
    public int minimumChanges(String s, int k) {
        int[][] dp = new int[s.length() + 1][k + 1];
        int [][]cost = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j =i+1; j < s.length(); j++) {
                cost[i][j] = semipalindrome(s.substring(i, j+1));
            }
        }
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i < 2 * j) continue;
                for(int o = 0; o < i; o++){
                    if (i - o < 2){ //minimum length of string would be greater than k
                        continue;
                    }
                    if (dp[o][j-1] < Integer.MAX_VALUE/2) {
                      dp[i][j] = Math.min(dp[o][j-1] + cost[o][i-1], dp[i][j]);
                    }
                }
            }
        }
        return dp[s.length()][k];
    }

    int semipalindrome(String s) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (s.length() % i == 0) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    StringBuilder temp = new StringBuilder();
                    for (int o = 0; o < s.length(); o += i) {
                        temp.append(s.charAt(o + j));
                    }
                    count += palindrome(temp.toString());
                }
                ans = Math.min(ans, count);
            }
        }
        return ans;
    }

    int palindrome(String x) {
        int st = 0;
        int lt = x.length() - 1;
        int count = 0;
        while (st < lt) {
            if (x.charAt(st) != x.charAt(lt)) {
                count++;
            }
            st++;
            lt--;
        }
        return count;
    }

}