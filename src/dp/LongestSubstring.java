package dp;

import java.util.Arrays;

public class LongestSubstring {

    public static void main(String[] args) {
        int[] test = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(test));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[]dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int largest = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            largest = Math.max(largest, dp[i]);
        }
        return largest;
    }
}
