// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int min = nums.get(0); 
//         int sum = 0;
//         for(int i = 0; i < nums.size(); i++){
//             sum += nums.get(i);
//         }
//         if (sum <= 0){
//             return -1;
//         }
//         int leftid = sum / l;
//         int rightid = sum /r;
//         if (leftid < nums.size()){
//             min = Math.min(min , nums.get(leftid));
//         }
//         if (rightid < nums.size()){
//             min = Math.min(min , nums.get(rightid));
//         }
//         if (min <= 0){
//             return  -1;
//         }
//         return min;
//     }
// }
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int [] sum = new int[nums.size()];
        sum[0] = nums.get(0);
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + nums.get(i);
        }
        for(int i = 0; i < nums.size(); i++){
          int last = i;
          while(last < nums.size()){
            if (last-i+1 >= l && last-i+1 <= r){
                int currsum = sum[last] - (i > 0 ? sum[i-1] : 0);
                if (currsum > 0){
                    min = Math.min(min, currsum);
                }
            }
            last++;
            }
        }
        if (min != Integer.MAX_VALUE){
            return min;
        }
        return -1;
    }
}