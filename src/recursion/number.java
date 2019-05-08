package recursion;


/**
 * @Author: zouhongxue
 * @Date: 2019/4/25 2:27 PM
 */
public class number {
    private static char[] result;

    public static void main(String[] args) {
        int n = 2;
        result = new char[n];
        for (int i = 0; i < 10; i++) {
            result[0] = (char)i ;
            allSort(result, n, 0);
        }
    }

    private static void allSort(char[] result, int length, int index) {
        if (index == length -1) {
            print(result);
            return;
        }
        for (int i = 0; i < 10; i++) {
            result[index+1] = (char) i;
            allSort(result, length, index + 1);
        }
    }

    private static void print(char[] result) {
        boolean first = true;
        for (int i = 0; i < result.length; i++) {
            if (first && (int) result[i] == 0) {
                continue;
            }
            first = false;
            System.out.print((int) result[i]);
        }
        System.out.println();
    }
}
