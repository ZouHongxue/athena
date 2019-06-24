package dfs;

/**
 * @Author: coffee
 */
public class Sum {
    static int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return res;
    }

    void dfs(int[] nums, int S, int current, int sum) {
        if(current == nums.length) {
            if(sum == S) {
                res++;
            }
        }
        dfs(nums, S, current + 1, sum + nums[current]);
        dfs(nums, S, current + 1, sum - nums[current]);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1};
        Sum sum = new Sum();
        System.out.println(sum.findTargetSumWays(test, 1));
    }
}
