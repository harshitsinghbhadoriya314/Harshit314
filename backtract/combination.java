package backtract;

import java.util.ArrayList;
import java.util.List;

public class combination {
    TrieNode root = new TrieNode();

    public class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isend = false;
    }

    public TrieNode tri(String[] words) {
        for (String str : words) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.isend = true;
        }
        return root;
    }

    // public String comString(String ch, char[][] board, String ok, int id, int jd,
    // boolean[][] used) {
    // if (ok.equals("")) {
    // return ch;
    // }
    // if (id < 0 || jd < 0 || id >= board.length || jd >= board[0].length) {
    // return "";
    // }
    // if (used[id][jd] == true) {
    // return "";
    // }

    // if (ok.charAt(0) != board[id][jd]) {
    // return "";
    // }
    // ch += board[id][jd];
    // used[id][jd] = true;
    // ok = ok.substring(1);
    // String result = comString(ch, board, ok, id + 1, jd, used);
    // if (!result.equals("")) {
    // return result;
    // }
    // result = comString(ch, board, ok, id, jd + 1, used);
    // if (!result.equals("")) {
    // return result;
    // }
    // result = comString(ch, board, ok, id - 1, jd, used);
    // if (!result.equals("")) {
    // return result;
    // }
    // result = comString(ch, board, ok, id, jd - 1, used);
    // if (!result.equals("")) {
    // return result;
    // }
    // used[id][jd] = false;
    // return "";
    // }

    // public List<String> findWords(char[][] board, String[] words) {
    // List<String> reList = new ArrayList<>();
    // for (String str : words) {
    // boolean[][] used = new boolean[board.length][board[0].length];
    // for (int i = 0; i < board.length; i++) {
    // for (int j = 0; j < board[i].length; j++) {
    // used[i][j] = false;
    // String aString = comString("", board, str, i, j, used);
    // if (str.equals(aString) && !reList.contains(aString)) {
    // reList.add(aString);
    // }
    // }
    // }
    // }
    // return reList;
    // }

    public StringBuilder comString1(StringBuilder ans1, String[] words, char[][] board, int i, int j, TrieNode node,
            boolean[][] used, List<String> reList) {
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return new StringBuilder("");
        }
        if (used[i][j] == true) {
            return new StringBuilder("");
        }
        int index = board[i][j] - 'a';
        if (node.child[index] == null) {
            return ans1;
        }
        ans1.append(board[i][j]);
        used[i][j] = true;
        node = node.child[index];
        if (node.isend && !reList.contains(ans1.toString())) {
          reList.add(ans1.toString());
        }
        comString1(ans1, words, board, i, j + 1, node, used, reList);
        comString1(ans1, words, board, i + 1, j, node, used, reList);
        comString1(ans1, words, board, i - 1, j, node, used, reList);
        comString1(ans1, words, board, i, j - 1, node, used, reList);
        used[i][j] = false;
        ans1 = ans1.deleteCharAt(ans1.length() - 1);
        return ans1;
    }

    public List<String> findList(String[] words, char[][] board) {
        List<String> reList = new ArrayList<>();
            boolean[][] used = new boolean[board.length][board[0].length];
            StringBuilder ans1 = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++){
                    comString1(ans1, words, board, i, j, root, used, reList);
            }
        }
        return reList;
    }

    public static void main(String[] args) {
        combination cal = new combination();

        char[][] board = new char[][] { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
                { 'a', 'f', 'l', 'v' } };
        String[] words = new String[] { "oa", "oaa" };
        TrieNode val = cal.tri(words);
        System.out.println(val);
        System.out.println(cal.findList(words, board));
    }
}

