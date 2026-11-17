class Solution {
    public int countServers(int[][] grid) {
        int ans = 0;
        int[] rows = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    rows[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
