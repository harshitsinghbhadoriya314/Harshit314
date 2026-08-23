public class Predictwinner  {
    int score1 = 0;
    int score2 = 0;
    public int Player1(int []nums ,int start , int last){
     while(start <= last){
        if (score1 + nums[start] >= score1 + nums[last]){
            score1 += nums[start];
            start++;
            return score1;
        }
        else {
           score1 += nums[last];
           last--;
           return score1;
       }
    }
    return score1;
    }
    public int Player2(int []nums ,int start , int last){
     while(start <= last){
        if (score2 + nums[start] >= score2 + nums[last]){
            score2 += nums[start];
            start++;
        }
        else {
         score2 += nums[last];
         last--;
      }  
    } 
    return score2;
    }
    public boolean predictTheWinner(int[] nums) {
        int start = 0;
        int last = nums.length-1;
        while (nums.length != 0){
            score1 += Player1(nums, start, last);
            score2 += Player2(nums, start, last);
        }
        if (score1 > score2){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Predictwinner val = new Predictwinner();
        boolean go = val.predictTheWinner(new int [] {1,5,2});
        System.out.println(go);
    }
}

