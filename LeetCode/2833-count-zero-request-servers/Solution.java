class Solution {
    //     int [] arr = new int [queries.length];
    //     for(int i = 0; i < queries.length; i++){
    //         HashMap<Integer, Integer> already = new HashMap<>();
    //         for(int k = 0; k < logs.length; k++){
    //             already.put(logs[k][0] , 0);
    //         }
    //         int count = n;
    //         for(int j = 0; j < logs.length; j++){
    //             int last = queries[i];
    //             int start = last - x;
    //             int check = already.get(logs[j][0]);
    //             if (check == 1){
    //                 continue;
    //             }
    //             else if (logs[j][1] >= start && logs[j][1] <= last){
    //                 count--;
    //                 already.put(logs[j][0] , 1);
    //             }
    //         }
    //         arr[i] = count;
    //     }
    //     return arr;
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] arr = new int[queries.length];
        Integer[] id = new Integer[arr.length];
        int[] fre = new int[n + 1];
        Arrays.sort(logs, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < queries.length; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) ->
            Integer.compare(queries[a], queries[b])
        );
        int left = 0;
        int right = 0;
        int active = 0;
        for (int i = 0; i < id.length; i++) {
            int start = queries[id[i]] - x;
            int last = queries[id[i]];
            for (int j = right; j < logs.length; j++) {
                if (logs[j][1] <= last) {
                    int server = logs[j][0];
                    if (fre[server] == 0) {
                        active++;
                    }
                    fre[server]++;
                    right++;
                }
                else{
                    break;
                }
            }
            for (int j = left; j < right ; j++) {
                if (logs[j][1] < start) {
                    int server = logs[j][0];
                    fre[server]--;
                    if (fre[server] == 0) {
                        active--;
                    }
                    left++;
                }else{
                    break;
                }
            }
            arr[id[i]] = n - active;

        }
        return arr;
    }
}