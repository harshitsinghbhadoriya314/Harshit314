import java.util.Arrays;
class Q41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int positive = 1;
        for (int i = 0; i< nums.length;i++){
            if (nums[i] == positive){
                positive++;
            }
            else if (nums[i] > positive){
                return positive;
            }
        }
        return positive;    
        }
    public static void main(String [] args){
      Q41 val = new Q41();
      System.out.println(val.firstMissingPositive(new int[]{1}));
}
}