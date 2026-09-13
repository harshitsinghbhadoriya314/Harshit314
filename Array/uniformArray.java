class uniformArray {
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
}