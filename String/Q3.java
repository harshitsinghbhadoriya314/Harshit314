package String;
    //    String first = "";
    //    String newStr = "";
    //    for (int i = 0; i< s.length();i++){
    //       if (!first.contains(s.substring(i, i+1)){
    //         first += s.sustring(i, i+1);
    //       }
    //    }
    //    return unique(first); 
class Solution {
  public int lengthOfLongestSubstring(String s){
        int start = 0; int last = 0;
        String first = "";
        int maxlength = 0;     
        while (last < s.length()){
            if (!first.contains(s.substring(last, last+1))){
                first += s.substring(last,last+1);
                last++;
                maxlength = Math.max(maxlength, first.length());
            }
            else {
                start++;
                first = first.substring(1);
            }
        }
        return maxlength;
  }
}