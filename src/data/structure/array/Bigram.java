package data.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ {leetCode 1078} Bigram 分词
 * @Author: coffee
 */
public class Bigram {
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            List<String> result = new ArrayList<>();
            String[] words = text.split(" ");
            boolean firstFlag = false, secondFlag = false;
            for (String word : words) {
                if (firstFlag && secondFlag) {
                    result.add(word);
                    firstFlag = false;
                    secondFlag = false;
                    continue;
                }

                if (!word.equals(first) && !word.equals(second)) {
                    firstFlag = false;
                    secondFlag = false;
                    continue;
                }

                if (word.equals(first)) {
                    firstFlag = true;
                }

                if (word.equals(second) && firstFlag) {
                    secondFlag = true;
                }
            }
            return result.toArray(new String[0]);
        }
    }
}
