class Solution {
    public int numOfSubarrays(int[] arr) {
        int max = 1000000007;
        int ans = 0;
        int even = 1;
        int odd = 0;
        int sum1 =0;
        int [] sum = new int [arr.length];
        for(int i = 0; i< arr.length; i++){
            sum1 += arr[i];
            if (sum1 % 2 != 0){
                ans = (ans + even) % max;
                odd++;
            }
            else {
                ans = (ans + odd) % max;
                even++;
            }
        }
        return ans;
    }
}