package leetcode;

import java.util.Arrays;

public class LC26 {
    public static void main(String[] args) {
        int[] test = new int[] {0,0,1,1,1,2,2,3,3,4};
        int i = removeElement(test);
        System.out.println(i);
        System.out.println(Arrays.toString(test));
    }

    public static int removeElement(int[] nums) {
        int p1 = 1;
        int currentValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currentValue) {
                nums[p1++] = nums[i];
                currentValue = nums[i];
            }
        }
        return p1;
    }
}
