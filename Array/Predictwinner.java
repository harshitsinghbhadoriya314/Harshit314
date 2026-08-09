public class Predictwinner  {
    int score1 = 0;
    int score2 = 0;
    public int Player1(int []nums ,int start , int last){
     while(start <= last){
        if (score1 + nums[start] > score2){
            score1 += nums[start];
            start++;
            return Player2(nums, start, last);
        }
        else {
           score1 += nums[last];
           last--;
           return Player2(nums, start, last);
       }
    }
    return score1;
    }
    public int Player2(int []nums ,int start , int last){
     while(start <= last){
        if (score2 + nums[start] > score1){
            score2 += nums[start];
            start++;
            return Player1(nums, start, last);
        }
        else {
         score2 += nums[last];
         last--;
         return Player1(nums, start, last);
      }  
    } 
    return score2;
    }
    public boolean predictTheWinner(int[] nums) {
        int start = 0;
        int last = nums.length-1;
        score1 = Player1(nums, start, last);
        if (score1 >= score2) {
            return true;
        }
        return false;
        }
}

