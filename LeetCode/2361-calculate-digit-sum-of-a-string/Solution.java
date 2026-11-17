class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k){
           String mini = mini(s, k);
           s = mini; 
        }
        return s;
    }
    String mini(String s, int k){
        int start = 0;
        int last = 0;
        String newStr = "";
        for(int i = start; i < s.length(); i = i + k){
            last = k + i;
            int sum = 0;
            while(start < last && start < s.length()){
                sum += s.charAt(start) - '0';
                start++;
            }
            newStr += String.valueOf(sum);
        }
        return newStr;
    }
}