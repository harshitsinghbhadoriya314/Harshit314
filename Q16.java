import java.util.Arrays;

class Q16 {
    // public int threeSumClosest(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int i = 0;
    //     int[] diff = new int[nums.length];
    //     int[] sum = new int[nums.length];
    //     int smalldiff = nums.length;
    //     while (i < nums.length) {
    //         int start = i + 1;
    //         int last = nums.length -1;
    //         while (start < last) {
    //             sum[i] = nums[i] + nums[start] + nums[last];
    //             diff[i] = target - sum[i];
    //             smalldiff = mini(diff,start);
              
    //             start++;

    //         }
    //         i++;
    //     }
    //     return sum[smalldiff];
    // }

    // public int mini(int[] arr, int index) {
    //     int min = arr.length;
    //     int min_index = arr.length;
    //     for (int i = 0; i < index; i++) {
    //         if (arr[i] < min) {
    //             min = arr[i];
    //             min_index = i;
    //         }
    //     }
    //     return min_index;

    // }
     public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int closestSum = target;
        while (i < nums.length){
           int start= i +1;
           int last = nums.length -1;
           while(start < last){
               int sum = nums[i] + nums[start] + nums[last];
               int diff = Math.abs(target - sum);
                if (sum < target){
                  closestSum =sum;
                  start++;
                }
                else if (sum > target){
                  closestSum = sum;
                  last--;
                }
                else {
                  return sum;
                }
              }
              i++;
            }
            return closestSum;
  }
    public static void main(String[] args){
      Q16 go = new Q16();
      int [] nums = {1, 1, -1};
      System.out.println(go.threeSumClosest(nums, 2));        
    }
}