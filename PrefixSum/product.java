import java.util.Arrays;
class product{
    public int[] productExceptSelf(int[] nums) {
        int [] pref = new int[nums.length];
        int [] suff = new int[nums.length];
        int [] result = new int[nums.length];
        int m = nums.length-1;
        pref[0] = nums[0];
        suff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i+1] * nums[i];
            System.out.println(pref[i]);
        }
        for (int i = 1; i < suff.length; i++) {
            suff[i] = suff[i-1]*nums[i-1];
            System.out.println(suff[i]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = pref[i] * suff[i]; 
        }
        System.out.println(pref[0]);
        System.out.println(suff[0]);
        return result;
        }
    //     int product = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         product = nums[i]*product;
    //         nums[i] = product;
    //     }
    //     int [] arr = new int[nums.length];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = nums[(nums.length-1)-i];           
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         if (nums[i] > arr[i] && nums[i] - arr[i] > nums.length){
    //            arr[i] = nums[i]/nums.length;
    //         }
    //         else if(nums[i] > arr[i]){
    //             arr[i] = nums[i] + arr[i]; 
    //         }
    //         else {
    //             arr[i] = nums[i] * arr[i];
    //         }
    //     }
    //  return arr;
    // }

    public static void main(String[] args) {
      product val = new product();
      System.out.println(Arrays.toString(val.productExceptSelf(new int[] {1, 2, 3, 4}))); 
    }
}