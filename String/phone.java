import java.util.*;

class phone {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> val = new HashMap<>();
        val.put(2, "abc");
        val.put(3, "def");
        val.put(4, "ghi");
        val.put(5, "jkl");
        val.put(6, "mno");
        val.put(7, "pqrs");
        val.put(8, "tuv");
        val.put(9, "wxyz");
        List<String> arr = new ArrayList<>();
        List<String> array = new ArrayList<>();
        if (digits.length() < 2) {
            int value = Integer.parseInt(digits);
            String s = val.get(value);
            for (int i = 1; i <= s.length(); i++) {
                String s1 = s.substring(i - 1, i);
                arr.add(s1);
            }
            return arr;
        }
        int v1 = digits.charAt(0) - '0';
        System.out.println(v1);
        String ans = val.get(v1);
        System.out.println(ans);
        for (int j = 1; j <= ans.length(); j++) {
            String alpha = ans.substring(j - 1, j);
            List<String> next = letterCombinations(digits.substring(1));
            for (int k = 1; k <= next.size(); k++) {
                System.out.println(alpha);
                String nextalpha = "" + alpha + next.get(k - 1);
                System.out.println(nextalpha);
                array.add(nextalpha);
            }
        }
    return array;

    }

    public static void main(String[] args) {
        phone val = new phone();
        System.out.println(val.letterCombinations("234"));
    }
}