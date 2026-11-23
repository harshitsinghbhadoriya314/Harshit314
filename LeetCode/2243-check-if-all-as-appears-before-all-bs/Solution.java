class Solution {
    public boolean checkString(String s) {
        boolean bs = false;
        for(char ch : s.toCharArray()){
            if (ch == 'b'){
                bs = true;
            }
            else if (bs == true && ch == 'a'){
                return false;
            }            
        }
        return true;
    }
}