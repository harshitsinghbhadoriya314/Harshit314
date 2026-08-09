class romantoint {
    public int romanToInt(String s) {
        int sum = 0;
        int j = 0;
        int index = 0;
        while (j < 6){
            if (s.contains("IV")){
                sum += 4;
                index = s.indexOf("IV");
                s = s.substring(0, index) + s.substring(index+2);
            }
            else if (s.contains("IX")){
                sum += 9;
                 index = s.indexOf("IX");
                s = s.substring(0, index) + s.substring(index+2);
            }
            else if (s.contains("XL")){
                sum += 40;
                index = s.indexOf("XL");
                s = s.substring(0, index) + s.substring(index+2);
            }
            else if (s.contains("XC")){
                sum += 90;
                index = s.indexOf("XC");
                s = s.substring(0, index) + s.substring(index+2);
            }
            else if (s.contains("CD")){
                sum += 400;
                index = s.indexOf("CD");
                s = s.substring(0, index) + s.substring(index+2);
            }
            else if (s.contains("CM")){
                sum += 900;
                index = s.indexOf("CM");
                s = s.substring(0, index) + s.substring(index+2);
            }
            j++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                sum += 1;
            } else if (s.charAt(i) == 'V') {
                sum += 5;
            } else if (s.charAt(i) == 'X') {
                sum += 10;
            } else if (s.charAt(i) == 'L') {
                sum += 50;
            } else if (s.charAt(i) == 'C') {
                sum += 100;
            } else if (s.charAt(i) == 'D') {
                sum += 500;
            } else if (s.charAt(i) == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
}