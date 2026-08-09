class Q5 {
    public String longestPalindrome(String s) {
        int start = 0;
        int last = s.length()-1;
        String longString = "";
        while (start < last) {
            if (s.length() < 3) {
                return s.substring(0, last - 1);
            } else if (s.charAt(start) != s.charAt(last)) {
                start++;
                last--;
            } else {
                return "";
            }
        }
        return longString;
    }

    public static void main(String[] args) {
        Q5 v = new Q5();
        System.out.println(v.longestPalindrome("aaaaaa"));
    }
}