package sort;

/**
 * @Author: coffee
 */
public class ExceptZero {
    public static void main(String[] args) {
        oN2Solution();
        oNSolution();
    }

    private static void oNSolution() {
        int[] arr = new int[]{1, 3, 0, 8, 7, 0, 5, 0, 1, 0};
        int head = 0;
        boolean firstZero = true;
        for (int index = 0; index < arr.length; ) {
            if(arr[index] != 0) {
                if(firstZero) {
                    index++;
                } else {
                    arr[head] = arr[index];
                    arr[index] = 0;
                    head++;
                    index++;
                }
            } else {
                if(firstZero) {
                    head = index;
                    firstZero = false;
                    index++;
                } else {
                    index++;
                }
            }
        }

        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }

    private static void oN2Solution() {
        int[] arr = new int[]{1, 3, 0, 8, 7, 0, 5, 0, 1, 0};
        for (int index = arr.length - 1, hold = arr.length - 1; index >= 0; ) {
            if (arr[index] == 0) {
                if (index == hold) {
                    index--;
                    hold--;
                    continue;
                } else {
                    for (int i = index; i < hold; i++) {
                        arr[i] = arr[i+1];
                    }
                    arr[hold] = 0;
                    hold--;
                }
            }
            index--;
        }

        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
