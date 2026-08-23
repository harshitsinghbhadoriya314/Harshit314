class prefixsum {
    public int contains(int [] nums,int sum){
        int i = 0;
        while(i < nums.length){
            if (nums[i] == sum){
                sum +=1;
                i = 0;
            }
            else {
            i++;  
            }
        }
        return sum;
    }

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        while(i < nums.length) {
            if (nums[i-1] > nums[i]) {
                break;
            }
            else {
                sum = sum + nums[i];
                System.out.println(sum);
                i++;
            }
        }
        
        return contains(nums, sum);
    }
    public static void main(String[] args){
      prefixsum val  = new prefixsum();
      System.out.print(val.missingInteger(new int []{1,1, 1,1,1,1,1}));
    }
}