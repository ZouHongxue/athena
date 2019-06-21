package string;

/**
 * 最长回文串
 * @Author: coffee
 */
public class LongestString {
    public static void main(String[] args) {
        String test = "afdhjjhddkk";
        String result = "";
        for (int i = 0; i < test.length(); i++) {
            String tmp = expand(test, i);
            if (tmp.length() > result.length()) {
                result = tmp;
            }
        }
        System.out.println(result);
    }

    private static String expand(String test, int i) {
        int head = i-1, end = i+1;
        //偶数回文特殊处理
        if (end < test.length()) {
            if (test.charAt(i) == test.charAt(end)) {
                end++;
            }
        }

        while (head >= 0 && end < test.length()) {
            if (test.charAt(head) != test.charAt(end)) {
                return test.substring(head + 1, end);
            }
            head--;
            end++;
        }
        return String.valueOf(test.charAt(i));
    }
}
