//         int [] idx = new int[tasks.length];
//         for(int i = 0; i < tasks.length; i++){
//             idx[i] = i;
//         }
//         int [] serverloc = new int [server.length];
//         for(int i = 0; i < servers.length; i++){
//             serverloc.put(servers[i], i);
//         }
//         Queue<Integer> wait = new LinkedList<>();
//         Queue<Integer> process = new LinkedList<>();
//         Stack<Integer> server = new Stack<>();
//         Arrays.sort(servers);
//         int [] task_Track = new int [tasks.length];
//         for(int i = servers.length-1; i >=0; i--){
//             server.push(servers[i]);
//         }
//         process.add(tasks[0]);
//         int second = 0;
//         int prev = 0;
//         int prevserver = 0;
//         int [] ans = new int [tasks.length];
//         int tempsec = 0;
//         int i = 0;
//         int server_Stack = 0;
//         boolean [] valid = new boolean [servers.length];
//         while(!process.isEmpty() && i < ans.length){
//             if (tempsec == task_Track[prev]){
//                 server.push(server_Stack);
//                 ans[i-1] = serverloc.get(server_Stack);
//             }
//             else if(valid[serverloc.get(server_Stack)]){
//                 wait.add(server_Stack);
//                 valid[serverloc.get(server_Stack)] = false;
//                 ans[i-1] = serverloc.get(server_Stack);
//                 server_Stack = wait.remove();
//                 valid[serverloc.get(server_Stack)] = true;
//             }
//             else {
//                server_Stack = server.pop();
//             }
//             int task = process.remove();
//             prevserver = server_Stack;
//             task_Track[idx[i]] = task;
//             prev = idx[i];
//             second = i;
//             tempsec += task;
//             process.add(tasks[i+1]);
//         }
//         return ans;
//     }
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int currtime = 0;
        Queue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        Queue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        int[] ans = new int[tasks.length];
        int i = 0;
        int j = 0;
        while (i < servers.length) {
            free.add(new int[] { servers[i], i });
            i++;
        }
        while (j < tasks.length) {
            currtime = Math.max(currtime, j);
            while (!busy.isEmpty() && busy.peek()[0] <= currtime) {
                int[] temp = busy.poll();
                free.add(new int[] { temp[1], temp[2] });
            }
            if (free.isEmpty()) {
                currtime = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= currtime) {
                    int[] temp = busy.poll();
                    free.add(new int[] { temp[1], temp[2] });
                }
            }
            int[] server = free.poll();
            ans[j] = server[1];
            int time = currtime + tasks[j];
            busy.add(new int[] { time, server[0], server[1] });

            j++;
        }
        return ans;
    }
}