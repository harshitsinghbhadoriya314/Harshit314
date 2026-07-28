public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        String sm = smallString(strs);
        while (sm.length() > 0) {
            int count = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].startsWith(sm)) {
                    count++;
                }
            }
            if (count != strs.length) {
                sm = sm.substring(0, sm.length() - 1);
            }
            else{
                break;
            }
        }
        return sm;
    }

    public String smallString(String[] str) {
        String Small = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() < Small.length()) {
                Small = str[i];
            }
        }
        return Small;
    }
}
