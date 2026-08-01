import java.util.Arrays;

public class Q27 {
    class Solution {
    public static void swap(int [] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void sort(int [] nums, int start, int lst){
        Arrays.sort(nums);
    }
    public static int removeElement(int[] nums, int val) {
         int start = 0;
         int lst = nums.length-1;
         int count = 0;
         while(start <= lst){
           if(nums[start] == val){
             swap(nums, start, lst);
             lst--;
             count++;
           }                                
           else {
            start++;
           }
         }
         return nums.length - count;        
    }
    public static void main(String [] args){
        int [] nums = {3,2,2,3};
        int val = 3; // Value to remove
        int[] expectedNums = {2,2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.
        int k = removeElement(nums, val); // Calls your implementation
        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }
    }
}
}
