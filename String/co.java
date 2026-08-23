import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.script.Invocable;

class co {
    public void permStringBuilders(List<String> ans, String arr, String[] word, boolean[] used) {
        if (arr.length() == word[0].length() * word.length) {
            ans.add(arr);
            return;
        }
        for (int i = 0; i < word.length; i++) {
            if (used[i]) {
                continue;
            }
            if (arr.contains(word[i])) {
                return;
            }
            int le = arr.length();
            arr += word[i];
            System.out.println(word[i]);
            used[i] = true;
            permStringBuilders(ans, arr, word, used);
            used[i] = false;
            arr = arr.substring(0, le);
        }
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        String arr = "";
        List<String> ans = new ArrayList<>();
        List<Integer> resuList = new ArrayList<>();
        boolean[] used = new boolean[words.length];
        permStringBuilders(ans, arr, words, used);
        for (String string : ans) {
            if (s.contains(string.toString())) {
                System.out.println(string);
                int id = s.indexOf(string.toString());
                resuList.add(id);
            }
        }
        return resuList;
    }

    public int freq(HashMap<String, Integer> val, String[] words) {
        int id = 1;
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (val.containsKey(words[i])) {
                int id1 = val.get(words[i]);
                val.put(words[i],id1 +1);
                sum += 1;
            } else {
                val.put(words[i], id);
                sum += 1;
            }
        }
        return sum;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> Characmap = new HashMap<>();
        int value = freq(Characmap, words);
        List<Integer> reList = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return reList;
        }
        if (words[0].length() * words.length > s.length()) {
            return reList;
        }
        int Last = 0;
        int start = 0;
        while (start + words[0].length() * words.length <= s.length()) {
            String curr = s.substring(Last, start + words[0].length() * words.length);
            String[] words1 = new String[words.length];
            HashMap<String, Integer> remap = new HashMap<>();
            for (int i = 0; i < words1.length; i++) {
                words1[i] = curr.substring(i * words[0].length(), i * words[0].length() + words[0].length());
                int fre = Characmap.get(words1[i]);
                remap.put(words1[i], fre);
                if(Characmap.get(words1[i]) < remap.get(words1[i])) {
                   break;
                }
            }
        }
        return reList;
    }

    public static void main(String[] args) {
        co val = new co();
        System.out.println(
                val.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
    }
}