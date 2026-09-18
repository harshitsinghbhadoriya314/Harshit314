class uniform {
    public boolean uniformArray(int[] nums1) {
     boolean ans = false;
     int nums2 [] = new int[nums1.length];
     for(int i = 0;i < nums1.length; i++){
        for(int j = 0; j < nums1.length; j++){
            if (i == j){
                nums2[i] = nums1[i];
            }
            else {
                nums2[i] = nums1[i] - nums1[j];
            }
        }
     }
      if(nums1.length == nums2.length){
        ans = true;
      }
    return ans;
    }
    ///Leetcode different problem
    public boolean uniformArray(int[] nums1) {
        boolean Checkup = check(nums1);
        if(Checkup){
            return Checkup;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min = Math.min(min, nums1[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0 && nums1[i] - min >= 1) {
                nums1[i] = nums1[i] - min;
            }
        }
        return check(nums1);
    }

    public boolean check(int[] nums1) {
        boolean even = true;
        boolean odd = true;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                even = false;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0) {
                odd = false;
            }
        }
        return even || odd;
    }
}
