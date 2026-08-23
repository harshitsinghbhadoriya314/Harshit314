class Q5 {
    public boolean ISPalindrome(String s) {
      int start = 0;
      int last = s.length()-1;
      while(start <= last){
        if (s.charAt(start) != s.charAt(last)) {
            return false;
        }
         start++;
         last--;

      }
      return true;
    }

    public String longestPalindrome(String s) {
        int left = 0;
        String longstr = "";
        while (left <= s.length()) {
           int right = left + 1;
            while (right <= s.length()) {
                if (ISPalindrome(s.substring(left, right)) && s.substring(left, right).length() > longstr.length()) {
                    longstr = s.substring(left, right);
                }
                right++;
            }
            left++;
        }
        return longstr;
    }
}