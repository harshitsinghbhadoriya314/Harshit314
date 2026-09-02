import java.util.ArrayList;
import java.util.List;

class textjustification {
    List<String> result = new ArrayList<>();

    public String adjust(boolean LastLine, int start, int maxWidth, int extra, String[] words, int wordsCount, int gap,
            int space, int perspace) {
        String Adjusted = "";
        int Count_words = wordsCount;
        for (int i = start; i < wordsCount + start; i++) {
            if (LastLine) {
                Adjusted += words[i];
                if (i != words.length - 1) {
                    Adjusted += " ";
                } else {
                    for (int j = 0; j < space; j++) {
                        Adjusted += " ";
                    }
                }
            }
            else {
                if(Count_words == 1 && wordsCount == 1) {
                    Adjusted += words[i];
                    for (int j = 0; j < space; j++) {
                        Adjusted += " ";
                    }

                } 
                else if (Count_words == 1 && wordsCount > 1){
                    Adjusted += words[i];
                }else {
                    Adjusted += words[i];
                    for (int j = 0; j < perspace; j++) {
                        Adjusted += " ";
                    }
                    if (extra > 0) {
                        Adjusted += " ";
                        extra -= 1;
                    }
                }
            }
            Count_words -= 1;
        }
        return Adjusted;
    }

    public int justify(int start, String[] words, int maxWidth) {
        String sample = "";
        String Adjusted = "";
        int wordsCount = 0;
        int gap = 0;
        int space = 0;
        int perspace = 0;
        int space_handle = 0;
        int bound_gap = 0;
        for (int i = start; i < words.length; i++) {
            if (i == words.length -1 && sample.length() + words[i].length() + gap +1<= maxWidth ){
                sample += words[i];
                wordsCount += 1;
                bound_gap = wordsCount;
                gap = wordsCount - 1;
                space = maxWidth - sample.length()-gap;
                if (gap == 0) {
                    perspace = space;
                    space_handle = 0;
                } else {
                    perspace = space / gap;
                    space_handle = space % gap;
                }
                System.out.println(i + "id");
                System.out.println("NOTadjusted");
                Adjusted = adjust(true, start, maxWidth, space_handle, words, wordsCount, gap, space, perspace);
                result.add(Adjusted);
                return words.length;
            }
            if (sample.length() + words[i].length() + gap<= maxWidth) {
                wordsCount += 1;
                gap = wordsCount - 1;
                sample += words[i];
                space = maxWidth - sample.length();
                if (gap == 0) {
                    perspace = space;
                    space_handle = 0;
                } else {
                    perspace = space / gap;
                    space_handle = space % gap;
                }
                System.out.println(words[i]);

            } else {
                // for condtion where srting length greater than ne rows length or maxlength
         System.out.println(i + "i1d");       System.out.println("Adjusted");
                Adjusted = adjust(false, start, maxWidth, space_handle, words, wordsCount, gap, space, perspace);
                result.add(Adjusted);
                start = i;
                return start;
            }
        }
        return start;
    }

    public void Validspace(List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            while (result.get(i).length() > 0 && result.get(i).charAt(0) == ' ') {
                result.set(i, result.get(i).substring(1));
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0;
        while (start < words.length) {
            System.out.println(start);
            System.out.println("start");
            start = justify(start, words, maxWidth);
        }
        Validspace(result);
        return result;
    }

    public static void main(String[] args) {
        textjustification ok = new textjustification();
        System.out.println(
                ok.fullJustify(new String[] {"Science","is","what","we",
                "understand","well","enough","to","explain","to","a","computer.",
                "Art","is","everything","else","we","do"}, 20));
    }

}