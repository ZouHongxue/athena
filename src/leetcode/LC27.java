package leetcode;

import java.util.Arrays;

public class LC27 {
    public static void main(String[] args) {
        int[] test = new int[] {0,1,2,2,3,0,4,2};
        int i = removeElement(test, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(test));
    }

    public static int removeElement(int[] nums, int val) {
        int p1 = 0;
        for (int num : nums) {
            if (num != val) {
                nums[p1++] = num;
            }
        }
        return p1;
    }
}
