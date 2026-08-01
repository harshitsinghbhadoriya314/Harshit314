class Q33{
    public int search(int[] nums, int target) {
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                int k = binary(nums, 0, j, target);
                if (k != -1) {
                    return k;
                }
                return binary(nums, j+1, nums.length-1, target);
            }
        }
        return binary(nums, 0, nums.length - 1, target);
    }

    // int i=1;
    // while(i< nums.length){
    //    if (nums[i-1] > nums[i]){
    //      int j = binary(nums, 0,i-1,target);
    //      if ( j == -1){
    //         return binary(nums, i, nums.length -1, target);
    //      }
    //    }
    //    else {
    //     i++;
    //    }
    // }
    public int binary(int[] nums, int start, int last, int target) {
        while (start <= last) {
            int mid = start + (last - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                last = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}