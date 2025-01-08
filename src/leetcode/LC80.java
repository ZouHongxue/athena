package leetcode;

import java.util.Arrays;

public class LC80 {
    public static void main(String[] args) {
        int[] test = new int[] {0,0,1,1,1,1,2,3,3};
        int i = removeElement(test);
        System.out.println(i);
        System.out.println(Arrays.toString(test));
    }

    public static int removeElement(int[] nums) {
        int p1 = 1;
        int currentValue = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentValue && count == 1) {
                count++;
                nums[p1++] = nums[i];
            } else if (nums[i] != currentValue) {
                nums[p1++] = nums[i];
                currentValue = nums[i];
                count = 1;
            }
        }
        return p1;
    }
}
