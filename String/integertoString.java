class integertoString {
    String [] english = new String[] {"One", "Two", "Three", "Four", "Five" , "Six" , "Seven" ,"Eight" , "Nine", "Ten", "Eleven" , "Twelve", "Thirteen", "Fourteen", "Fifteen" , "Sixteen", "Seventeen","Eighteen", "Nineteen"};
    String [] tens = new String [] {
        "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", 
    };
    
    public String calls(int num){
        String ans = "";
        while(num > 0){
        if(num < 20){
            ans = ans + english[num -1] + " ";
            num = 0;
        }
        else if (num < 100){
            ans = ans + tens[(num/10)-2] + " ";
            num = num%10;
        }
        else if(num < 1000) {
           ans = english[(num/100)-1] +" " + "Hundred ";
            num = num % 100;
        }
        }
        return ans;
    }
   
    public String numberToWords(int num){
        if(num <1){
            return "Zero";
        }
        if(num < 100){
            return calls(num).trim(); 
        }
        String ans = String.valueOf(num);
        int len = ans.length();
        String Real_result = "";
        for(int i = 1; i <= (ans.length()/3) + 1; i++){
            int start = ans.length() - 3*i;
            if(len == 0){
                return Real_result.trim();
            }
            if(start > ans.length() || start < 0){
                start = 0;
            }
            String ok = ans.substring(start, len);
            len = start;
            int change = Integer.parseInt(ok);
            String result = calls(change);
            if(change != 0){
            if(i == 2){
                result = result + "Thousand ";
            }
            else if (i == 3){ 
                result = result + "Million ";
            }
            else if ( i == 4){
                result = result + "Billion ";
            }
            }
            Real_result = result + Real_result;  
        }
        return Real_result.trim();
    }

}