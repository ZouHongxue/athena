package sort;

import java.util.Arrays;

/**
 * @Author: zouhongxue
 * @Date: 2019/4/22 2:40 PM
 */
public class QuickSort {

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(array, left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int key = array[right];
        while (left < right) {
            while (left < right && array[left] < key) {
                ++left;
            }
            array[right] = array[left];
            while (left < right && array[right] > key) {
                --right;
            }
            array[left] = array[right];
        }
        array[right] = key;
        return right;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 7, 6, 9, 2, 8, 0, 3, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
