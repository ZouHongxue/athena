package sort;

/**
 * @Author: coffee
 */
public class AllSort {
    public static void main(String[] args) {
        String str = "abc";
        char[] charArr = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            charArr[i] = str.charAt(i);
        }
        permutation(charArr, 0, str.length() -1);
    }

    static void permutation(char[] charArr, int head, int length) {
        if (head == length) {
            System.out.println(charArr);
        } else {
            for(int i = head; i <= length; i++) {
                swap(charArr, head, i);
                permutation(charArr, head + 1, length);
                swap(charArr, head, i);
            }
        }
    }

    static void swap(char[] charArr, int i, int j) {
        char tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
    }
}
