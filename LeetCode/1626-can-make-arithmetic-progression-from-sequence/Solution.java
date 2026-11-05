class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int a = arr[0];
        int d = Math.abs(a - arr[1]);
        for(int i = 0; i < arr.length; i++){
            int val = a + i*d;
            if (val != arr[i]){
                return false;
            }
        }
        return true;
    }
}