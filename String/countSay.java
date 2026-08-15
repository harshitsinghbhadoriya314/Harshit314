class countSay {
        public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String result = countAndSay(n - 1);
        char samString = result.charAt(0);
        int count = 0;
        String ans = "";
        int i = 1;
        while (i <= result.length()) {
            if (result.charAt(i-1) == samString){
                count += 1;    
            }
            if (result.charAt(i-1) != samString){
                ans = ans + count + samString;
                samString = result.charAt(i-1);
                count = 1;
            }
            i++; 
        }
        ans = ans + count + samString;
        return ans;
        }
}