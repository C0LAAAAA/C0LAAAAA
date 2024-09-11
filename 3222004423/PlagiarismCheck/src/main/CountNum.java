package Main;

import java.util.List;

public class CountNum {

    public static int[] CountNum(List<String> text, List<String> mergetext) {
        int[] frequency = new int[mergetext.size()];
        for (String word : text) {
            for (int i = 0; i < mergetext.size(); i++) {
                if (word.equals(mergetext.get(i))) {
                    frequency[i]++;
                }
            }
        }
        return frequency;
    }

}
