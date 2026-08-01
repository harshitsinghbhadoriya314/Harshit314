class Q3{
    public int lengthOfLongestSubstring(String s){
       String first = "";
       for (int i = 0; i< s.length();i++){
          if (!first.contains(s.substring(i, i+1))){
            first += s.substring(i, i+1);
          }
       }
       return first.length(); 
    }
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        String s = "abcabcbb";
        System.out.println(q3.lengthOfLongestSubstring(s));
    }
}