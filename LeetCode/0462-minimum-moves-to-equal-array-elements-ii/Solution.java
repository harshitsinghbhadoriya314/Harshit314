class Solution {
    public int minMoves2(int[] nums) {
        int move = 0;
        Arrays.sort(nums);
        int mean = nums[(int)nums.length/2];
        for(int j =0; j< nums.length; j++){
            move += Math.abs(nums[j] - mean);
        }
        return move;
    } 
}