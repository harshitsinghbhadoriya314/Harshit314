class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Queue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        TreeSet<Integer> free = new TreeSet<>();
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[k];
        int j = 0;
        Integer server = 0;
        for(int i = 0 ; i < k ; i++){
            free.add(i);
        }
        while (j < load.length) {
            while (!busy.isEmpty() && arrival[j] >= busy.peek()[0]) {
                int[] temp = busy.remove();
                free.add(temp[1]);
            }
            if (free.isEmpty()){
                j++;
               continue;
            }
            else if (!free.isEmpty()) {
                server = free.ceiling(j % k);
                if (server == null){
                    server = free.first();
                }
                free.remove(server);
                busy.add(new int[] { load[j] + arrival[j], server });
                freq[server]++;
                j++;
            }
        }
        return result(ans, freq);
    }

    List<Integer> result(List<Integer> ans, int[] freq) {
        int[] copy = freq.clone();
        Arrays.sort(copy);
        int max = copy[copy.length - 1];
        for (int j = 0; j < freq.length; j++) {
            if (freq[j] == max) {
                ans.add(j);
            }
        }
        return ans;
    }
}